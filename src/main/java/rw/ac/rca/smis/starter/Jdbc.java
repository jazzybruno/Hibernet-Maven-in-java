package rw.ac.rca.smis.starter;
import java.sql.*;

public class Jdbc extends Exception{
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rwanda" , "bruno" , "Bruno@1980");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from provinces");
        while(resultSet.next()){
            System.out.print(resultSet.getInt("province_id"));
            System.out.print(" ");
            System.out.print(resultSet.getInt("districts"));
            System.out.print(" ");
            System.out.println(resultSet.getString("province_name"));
        }

        statement.close();
        connection.close();
    }
}
