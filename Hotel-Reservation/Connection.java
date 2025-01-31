import java.sql.*;

public class Connection {
    java.sql.Connection connection;
    Statement statement;

    Connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotelreservationsystem",
                "root",  // Replace with your MySQL username
                "kings0321!"   // Replace with your MySQL password
            );
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to database: " + e.getMessage());
        }
    }

    // Add method to close connections
    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
