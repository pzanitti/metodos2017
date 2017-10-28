package carnets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOCarnet {
    public static void insertar(Carnet carnet) {
        String sql = "INSERT INTO carnets VALUES\n"
                + "(null, ?,?,?)";
        
        try {
            Connection conn = DB.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, carnet.getClase().getId());
            pstmt.setString(2, carnet.getEmision().toString());
            pstmt.setString(3, carnet.getExpiracion().toString());
            pstmt.executeUpdate();
            
            int numero;
            sql = "SELECT last_insert_rowid();";
    
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            rs.next();
            numero = rs.getInt("last_insert_rowid()");
            carnet.setNumero(numero);
            
            DAOAuditoria.insertar("Emitida licencia " + numero);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    };
}
