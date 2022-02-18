package com.quyntess.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.quyntess.model.MyCalculator;

public class MyCalcRepository {

	static String url = "jdbc:mysql://localhost:3306/mycalc_quyntess";
	static String username = "calcapp";
	static String password = "passcode123";
	static String QUERY = "INSERT INTO my_calc (myFomula, result)"
	        + "VALUES (?, ?)";
    long id = 0;
	public long	 insertRecord (MyCalculator myCalc) {

try {
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver loaded!");
} catch (ClassNotFoundException e) {
    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
}
	System.out.println("Connecting database...");

    try (Connection conn = connect(); 
		 PreparedStatement pstmt = conn.prepareStatement(QUERY,
	                Statement.RETURN_GENERATED_KEYS)){

	            pstmt.setString(1, myCalc.getMyFormula());
	            pstmt.setString(2, myCalc.getResult());

	            int affectedRows = pstmt.executeUpdate();
	            // check the affected rows 
	            if (affectedRows > 0) {
	                // get the ID back
	                try (ResultSet rs = pstmt.getGeneratedKeys()) {
	                    if (rs.next()) {
	                        id = rs.getLong(1);
	                    }
	                } catch (SQLException ex) {
	                    System.out.println(ex.getMessage());
	                }
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
	        return id;
	}
	 public Connection connect() throws SQLException {
	        return DriverManager.getConnection(url, username, password);
	    }

}
