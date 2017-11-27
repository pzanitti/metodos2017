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
    
    public static void init(boolean completar) {
        String sql;
        try {
            Connection conn = DB.conectar();
            Statement stmt = conn.createStatement();

            sql = "CREATE TABLE IF NOT EXISTS carnets (\n"
                + " numero integer PRIMARY KEY AUTOINCREMENT,\n"
                + " clase char NOT NULL,\n"
                + " emision TEXT NOT NULL,\n"
                + " expiracion TEXT NOT NULL,\n"
                + " observaciones TEXT NOT NULL,\n"
                + " tipoDocumento TEXT NOT NULL,\n"
                + " numeroDocumento TEXT NOT NULL,\n"
                + " FOREIGN KEY(tipoDocumento, numeroDocumento) REFERENCES titulares(tipoDocumento, numeroDocumento)"
                + ");";
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS titulares (\n"
                + " tipoDocumento TEXT NOT NULL,\n"
                + " numeroDocumento TEXT NOT NULL,\n"
                + " apellidos TEXT NOT NULL,\n"
                + " nombres TEXT NOT NULL,\n"
                + " fechaNacimiento TEXT NOT NULL,\n"
                + " direccion TEXT NOT NULL,\n"
                + " grupoSanguineo TEXT NOT NULL,\n"
                + " factorSanguineo TEXT NOT NULL,\n"
                + " esDonante INTEGER NOT NULL,\n"
                + " PRIMARY KEY (tipoDocumento, numeroDocumento)\n"
                + ");";
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS auditoria (\n"
                + " numero INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " timestamp TEXT NOT NULL,\n"
                + " descripcion TEXT NOT NULL\n"
                + ");";
            stmt.execute(sql);
            
            if(completar) {
                DB.completarTablas(conn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void completarTablas(Connection conn) throws SQLException {
        String sql;
        Statement stmt = conn.createStatement();

        sql = "INSERT INTO carnets(clase, emision, expiracion, observaciones, tipoDocumento, numeroDocumento) VALUES\n"
                + "("
                + "'A', "
                + "'2015-11-22', "
                + "'2016-11-22', "
                + "'Nada', "
                + "'DNI', "
                + "12345678);";
        stmt.execute(sql);
        sql = "INSERT INTO carnets(clase, emision, expiracion, observaciones, tipoDocumento, numeroDocumento) VALUES\n"    
                + "("
                + "'A', "
                + "'2014-11-22', "
                + "'2017-11-22', "
                + "'Nada', "
                + "'DNI', "
                + "22313515);";
        stmt.execute(sql);
        sql = "INSERT INTO carnets(clase, emision, expiracion, observaciones, tipoDocumento, numeroDocumento) VALUES\n"
                + "("
                + "'A', "
                + "'2015-11-22', "
                + "'2018-11-22', "
                + "'Nada', "
                + "'DNI', "
                + "45487912);";
        stmt.execute(sql);
        sql = "INSERT INTO carnets(clase, emision, expiracion, observaciones, tipoDocumento, numeroDocumento) VALUES\n"
                + "("
                + "'A', "
                + "'2016-11-22', "
                + "'2020-11-22', "
                + "'Nada', "
                + "'DNI', "
                + "15245875);";
        stmt.execute(sql);
        
        
        sql = "INSERT INTO titulares(tipoDocumento, numeroDocumento, apellidos, nombres, fechaNacimiento, direccion, grupoSanguineo, factorSanguineo, esDonante) VALUES\n"
                + "('DNI', "
                + "12345678, "
                + "'Camela', "
                + "'Benito', "
                + "'1985-11-01', "
                + "'Direccion', "
                + "'B', "
                + "'+', "
                + "0);";
        stmt.execute(sql);  
        sql = "INSERT INTO titulares(tipoDocumento, numeroDocumento, apellidos, nombres, fechaNacimiento, direccion, grupoSanguineo, factorSanguineo, esDonante) VALUES\n"
                + "('DNI', "
                + "22313515, "
                + "'Quito', "
                + "'Armando Esteban', "
                + "'1905-12-12', "
                + "'Direccion', "
                + "'A', "
                + "'+', "
                + "0);";
        stmt.execute(sql);
        sql = "INSERT INTO titulares(tipoDocumento, numeroDocumento, apellidos, nombres, fechaNacimiento, direccion, grupoSanguineo, factorSanguineo, esDonante) VALUES\n"        
                + "('DNI', "
                + "15245875, "
                + "'Oria', "
                + "'Susana', "
                + "'1976-01-05', "
                + "'Direccion', "
                + "'O', "
                + "'-', "
                + "1);";
        stmt.execute(sql);
        sql = "INSERT INTO titulares(tipoDocumento, numeroDocumento, apellidos, nombres, fechaNacimiento, direccion, grupoSanguineo, factorSanguineo, esDonante) VALUES\n"        
                + "('DNI', "
                + "45487912, "
                + "'Cabezas', "
                + "'Rosa', "
                + "'1946-07-08', "
                + "'Direccion', "
                + "'O', "
                + "'+', "
                + "0);";
        stmt.execute(sql);
    }
}