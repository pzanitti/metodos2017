package carnets;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DB {
    static Connection conn = null;
    
    public static Connection conectar() {
        if (conn == null) {
            String url = "jdbc:sqlite:carnets.db";
            try {
                Connection nuevaConn = DriverManager.getConnection(url);
                conn = nuevaConn;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return conn;
    }
    
    public static void init() {
        String sql;
        try {
            Connection conn = DB.conectar();
            Statement stmt = conn.createStatement();

            sql = "CREATE TABLE IF NOT EXISTS carnets (\n"
                + " numero integer PRIMARY KEY AUTOINCREMENT,\n"
                + " clase char NOT NULL,\n"
                + " emision TEXT NOT NULL,\n"
                + " expiracion TEXT NOT NULL,\n"
                + " tipoDocumento TEXT NOT NULL,\n"
                + " numeroDocumento TEXT NOT NULL,\n"
                + " FOREIGN KEY(tipoDocumento, numeroDocumento) REFERENCES titulares(tipoDocumento, numeroDocumento)"
                + ");";
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS titulares (\n"
                + " tipoDocumento string NOT NULL,\n"
                + " numeroDocumento string NOT NULL,\n"
                + " apellidos string NOT NULL,\n"
                + " nombres string NOT NULL,\n"
                + " fechaNacimiento TEXT NOT NULL,\n"
                + " direccion string NOT NULL,\n"
                + " grupoSanguineo string NOT NULL,\n"
                + " factorSanguineo string NOT NULL,\n"
                + " esDonante integer NOT NULL,\n"
                + " observaciones string NOT NULL,\n"
                + " PRIMARY KEY (tipoDocumento, numeroDocumento)\n"
                + ");";
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS auditoria (\n"
                + " numero integer PRIMARY KEY AUTOINCREMENT,\n"
                + " timestamp string NOT NULL,\n"
                + " descripcion string NOT NULL\n"
                + ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}