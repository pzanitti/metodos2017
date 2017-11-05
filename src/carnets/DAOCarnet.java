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
import java.util.Optional;

public class DAOCarnet {
    public static void insertar(Carnet carnet) {
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
            carnet.setNumero(numero);
            
            DAOAuditoria.insertar("Emitida licencia " + numero + " a " + carnet.getTitular().getTipoDocumento().nombre + " " + carnet.getTitular().getNumeroDocumento());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    };
    
    public static List<Carnet> buscar (Titular unTitular) {
        ArrayList<Carnet> carnets = new ArrayList<>();
        
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
                Carnet carnet;
    
                try {
                    carnet = new Carnet(
                            Optional.empty(),
                            Clase.fromLetra(rs.getString("Clase").charAt(0)),
                            0,
                            unTitular
                    );
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date = LocalDate.parse(rs.getString("emision"), formatter);
                    carnet.setEmision(date);
                    carnets.add(carnet);
                } catch (Exception e) {
                }
//                System.out.println(rs.getInt("numero") +  "\t" + 
//                                   rs.getString("clase") + "\t" +
//                                   rs.getString("emision") + "\t" +
//                                   rs.getString("expiracion") + "\t" +
//                                   rs.getString("tipoDocumento") + "\t" +
//                                   rs.getDouble("numeroDocumento"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return carnets;
    }
}
