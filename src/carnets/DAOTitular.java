package carnets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DAOTitular {
    public static int insertar(Titular titular) {
        Objects.requireNonNull(titular);
        
        int val = 0;
        String sql = "INSERT INTO titulares VALUES\n"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            Connection conn = DB.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, titular.getTipoDocumento().nombre);
            pstmt.setString(2, titular.getNumeroDocumento());
            pstmt.setString(3, titular.getApellidos());
            pstmt.setString(4, titular.getNombres());
            pstmt.setString(5, titular.getFechaNacimiento().toString());
            pstmt.setString(6, titular.getDireccion());
            pstmt.setString(7, titular.getGrupoSanguineo().getGrupoSanguineo());
            pstmt.setString(8, titular.getFactorSanguineo().getFactor());
            pstmt.setBoolean(9, titular.isDonante());
            pstmt.setString(10, titular.getObservaciones());
            
            val = pstmt.executeUpdate();
            
            DAOAuditoria.insertar("Alta del titular " + titular.getApellidos() + ", " + titular.getNombres() + " con documento: " + titular.getTipoDocumento().nombre + " " + titular.getNumeroDocumento());
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return val;
    };
    
    
    public static Optional<Titular> obtener(TipoDocumento tipoDocumento, String numeroDocumento) throws SQLException {
        Objects.requireNonNull(tipoDocumento);
        Objects.requireNonNull(numeroDocumento);
        
        String sql = "SELECT * FROM titulares WHERE\n"
               + " tipoDocumento = ? AND\n"
               + " numeroDocumento = ?";
        try {
            Connection conn = DB.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, tipoDocumento.nombre);
            pstmt.setString(2, numeroDocumento);
            ResultSet rs    = pstmt.executeQuery();

            if (rs.next()) {

                Titular titular = new Titular(
                        tipoDocumento,
                        numeroDocumento,
                        rs.getString("apellidos"),
                        rs.getString("nombres"),
                        LocalDate.parse(rs.getString("fechaNacimiento"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        rs.getString("direccion"),
                        GrupoSanguineo.valueOf(rs.getString("grupoSanguineo")),
                        rs.getString("factorSanguineo").equals("+") ? FactorSanguineo.POSITIVO : FactorSanguineo.NEGATIVO,
                        rs.getBoolean("esDonante"),
                        rs.getString("observaciones")
                );
                
                return Optional.of(titular);
            }
            
            assert(!rs.next()); //Nunca debería haber dos titulares con igual clave
            
            return Optional.empty();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public static List<Titular> buscarPorCriterios(Criterios criterios) throws SQLException {
        Objects.requireNonNull(criterios);
        
        String sql = "SELECT * FROM titulares WHERE 1=1\n";
        
        if(criterios.apellidos.isPresent()) sql += "AND apellidos = ?\n";
        if(criterios.nombres.isPresent()) sql += "AND nombres = ?\n";
        if(criterios.grupoSanguineo.isPresent()) sql += "AND grupoSanguineo = ?\n";
        if(criterios.factorSanguineo.isPresent()) sql += "AND factorSanguineo = ?\n";
        if(criterios.donante.isPresent()) sql += "AND donante = ?\n";  
                
        try {
            Connection conn = DB.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            
            int index = 1;
            if(criterios.apellidos.isPresent()) pstmt.setString(index++, criterios.apellidos.get());
            if(criterios.nombres.isPresent()) pstmt.setString(index++, criterios.nombres.get());
            if(criterios.grupoSanguineo.isPresent()) pstmt.setString(index++, criterios.grupoSanguineo.get().nombre);
            if(criterios.factorSanguineo.isPresent()) pstmt.setString(index++, String.valueOf(criterios.factorSanguineo.get().signo));
            if(criterios.donante.isPresent()) pstmt.setInt(index++, criterios.donante.get() ? 1 : 0);  
            ResultSet rs    = pstmt.executeQuery();
            
            List<Titular> ret = new ArrayList<>();

            while (rs.next()) {

                Titular titular = new Titular(
                        TipoDocumento.fromNombre(rs.getString("tipoDocumento")),
                        rs.getString("numeroDocumento"),
                        rs.getString("apellidos"),
                        rs.getString("nombres"),
                        LocalDate.parse(rs.getString("fechaNacimiento"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        rs.getString("direccion"),
                        GrupoSanguineo.valueOf(rs.getString("grupoSanguineo")),
                        rs.getString("factorSanguineo").equals("+") ? FactorSanguineo.POSITIVO : FactorSanguineo.NEGATIVO,
                        rs.getBoolean("esDonante"),
                        rs.getString("observaciones")
                );
                
                assert(criterios.coinciden(titular));
                
                ret.add(titular);
            }
            
            return ret;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}
