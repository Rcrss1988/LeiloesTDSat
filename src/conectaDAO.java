
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conectaDAO {
    
    private PreparedStatement st; // Declaração da variável de declaração SQL pré-compilada.
    private ResultSet rs; // Declaração da variável de resultado de consulta SQL.

    public Connection connectDB() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/leiloes_td_sat?useSSL=false";
            conn = DriverManager.getConnection(url, "root", "472472");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
        }
        return conn;
    }
    
}
