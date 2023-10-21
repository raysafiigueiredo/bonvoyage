package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
	private static final String URL = "jdbc:mysql://localhost:3306/partiu";
	private static final String USUARIO = "root";
	private static final String SENHA = "root";

	public static Connection createConnectionMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
		return connection;
	}

	public static void main(String[] args) throws Exception {
		Connection conn = createConnectionMySQL();

		try {
			if (conn != null && !conn.isClosed()) {
				System.out.println(conn + "\n\n **** Conexão realizada com sucesso! ****");
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
}