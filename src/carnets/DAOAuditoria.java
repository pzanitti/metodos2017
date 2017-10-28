package carnets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DAOAuditoria {
    public static void insertar(String descripcion) {
        String sql = "INSERT INTO auditoria VALUES\n"
                + "(?, ?)";
        
        try {
            Connection conn = DB.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, LocalDateTime.now().toString());
            pstmt.setString(2, descripcion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    };
}
