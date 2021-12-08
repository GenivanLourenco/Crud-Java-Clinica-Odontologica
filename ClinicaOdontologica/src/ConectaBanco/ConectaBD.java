package ConectaBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConectaBD {
	public static Connection createConnectionToMySQL() throws SQLException {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/odonto","root","");
		return conn;
				
	}catch (ClassNotFoundException e){
		throw new SQLException(e.getException());
	}
		
	}
	
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Connection conn = createConnectionToMySQL();
	if(conn!=null) {
		System.out.println("conectado!!!");
		conn.close();
	}
}

public static PreparedStatement prepareStatement(String sql) {
	// TODO Auto-generated method stub
	return null;
}
}
