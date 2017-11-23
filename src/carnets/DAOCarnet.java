package carnets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class DAOCarnet {
    
    public static Carnet insertar(Carnet carnet) {
        Objects.requireNonNull(carnet);
        
        String sql = "INSERT INTO carnets VALUES\n"
                + "(null, ?,?,?,?,?)";
        
        try {
            Connection conn = DB.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Character.toString(carnet.getClase().letra));
            pstmt.setString(2, carnet.getEmision().toString());
            pstmt.setString(3, carnet.getExpiracion().toString());
            pstmt.setString(4, carnet.getTitular().getTipoDocumento().nombre);
            pstmt.setString(5, carnet.getTitular().getNumeroDocumento());
            pstmt.executeUpdate();
            
            int numero;
            sql = "SELECT last_insert_rowid();";
    
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            rs.next();
            numero = rs.getInt("last_insert_rowid()");
            
            DAOAuditoria.insertar("Emitida licencia " + numero + " a " + carnet.getTitular().getTipoDocumento().nombre + " " + carnet.getTitular().getNumeroDocumento());
            
            return new Carnet(numero, carnet.getClase(), carnet.getEmision(), carnet.getExpiracion(), carnet.getTitular());
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        assert false;
        return null;
    };
    
    public static List<Carnet> buscar (Titular unTitular) {
        Objects.requireNonNull(unTitular);
        
        List<Carnet> carnets = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String sql = "SELECT * FROM carnets WHERE\n"
               + "tipoDocumento = ? AND\n"
               + "numeroDocumento = ?";
        
        try {
            Connection conn = DB.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, unTitular.getTipoDocumento().nombre);
            pstmt.setString(2, unTitular.getNumeroDocumento());
            ResultSet rs    = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {

                Carnet carnet = new Carnet(
                        rs.getInt("numero"),
                        Clase.fromLetra(rs.getString("clase").charAt(0)),
                        LocalDate.parse(rs.getString("emision"), formatter),
                        LocalDate.parse(rs.getString("expiracion"), formatter),
                        unTitular
                );
                
                carnets.add(carnet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return carnets;
    }
    
    public static List<Carnet> expirados(Optional<LocalDate> expiracionDesde, LocalDate expiracionHasta) throws SQLException
    {
        Objects.requireNonNull(expiracionDesde);
        Objects.requireNonNull(expiracionHasta);
        if(expiracionDesde.isPresent() && expiracionHasta.isBefore(expiracionDesde.get())) throw new IllegalArgumentException("expiracionHasta no puede ser anterior a la expiracionDesde");
        
        String sql = "SELECT * FROM carnets WHERE expiracion <= ?\n";//" +  +  "\"\n";
        
        if(expiracionDesde.isPresent()) {
            sql += "AND expiracion >= ?\n";
        }
        
        sql += "ORDER BY expiracion ASC";
        
        try {
            Connection conn = DB.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, expiracionHasta.toString());
            if(expiracionDesde.isPresent()) pstmt.setString(2, expiracionDesde.get().toString());
            ResultSet rs    = pstmt.executeQuery();
            
            List<Carnet> ret = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            
            // loop through the result set
            while (rs.next()) {

                Carnet carnet = new Carnet(
                        rs.getInt("numero"),
                        Clase.fromLetra(rs.getString("clase").charAt(0)),
                        LocalDate.parse(rs.getString("emision"), formatter),
                        LocalDate.parse(rs.getString("expiracion"), formatter),
                        DAOTitular.obtener(TipoDocumento.fromNombre(rs.getString("tipoDocumento")), rs.getString("numeroDocumento")).get()
                );
                
                ret.add(carnet);
                
            }
            
            return ret;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    
    public static List<Carnet> vigentesPorCriterios(Criterios criterios) throws SQLException {
        Objects.requireNonNull(criterios);
        
        List<Carnet> ret =  DAOTitular.buscarPorCriterios(criterios).stream()
                                    .flatMap(t -> buscar(t).stream())
                                    .filter(c -> !c.isExpirado())
                                    .collect(Collectors.toList());
        
        assert ret.stream().allMatch(c -> !c.isExpirado() && criterios.coinciden(c.getTitular()));
        
        return ret;
    }
    
    
    /*
    -- SELECT *
    -- FROM `carnets` `C`
    --  INNER JOIN `titular` `T` ON (`C`.`tipoDocumento` = `T`.`tipoDocumento` AND `C`.`numeroDocumento` = `T`.`numeroDocumento`)

    SELECT `C`.`numero`, `C`.`clase`, `C`.`emision`, `C`.`expiracion`, `T`.`apellidos`, `T`.`nombres`, `C`.`tipoDocumento`, `C`.`numeroDocumento`
    FROM `carnets` `C`
      INNER JOIN `titular` `T` ON (`C`.`tipoDocumento` = `T`.`tipoDocumento` AND `C`.`numeroDocumento` = `T`.`numeroDocumento`)
    WHERE CAST(substr(`C`.`expiracion`,1,4) as INTEGER) <= 2019 -- Año
      AND CAST(substr(`C`.`expiracion`,6,2) as INTEGER) <= 1 -- Mes
      AND CAST(substr(`C`.`expiracion`,9,2) as INTEGER) <= 11 -- Dia
    */
}
