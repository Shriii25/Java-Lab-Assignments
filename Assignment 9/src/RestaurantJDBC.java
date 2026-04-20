import java.sql.*;

public class RestaurantJDBC {

    static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB";
    static final String USER = "root";
    static final String PASSWORD = "Shriya@25";

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = con.createStatement();

            System.out.println("Connected\n");

            stmt.executeUpdate("DELETE FROM MenuItem");

            stmt.executeUpdate("INSERT INTO MenuItem VALUES " +
                    "(1, 'Pasta', 120, 1)," +
                    "(2, 'Pizza', 90, 1)," +
                    "(3, 'Burger', 80, 2)," +
                    "(4, 'Fries', 60, 2)," +
                    "(5, 'Noodles', 110, 3)," +
                    "(6, 'Sandwich', 70, 1)," +
                    "(7, 'Paratha', 50, 4)," +
                    "(8, 'Pav Bhaji', 95, 5)," +
                    "(9, 'Paneer Tikka', 150, 1)," +
                    "(10, 'Coffee', 40, 1)");
            System.out.println("---- Items with Price <= 100 ----");
            printResult(stmt, "SELECT * FROM MenuItem WHERE Price <= 100");

            System.out.println("\n---- Items from Cafe Java ----");
            printResult(stmt,
                    "SELECT m.* FROM MenuItem m " +
                            "JOIN Restaurant r ON m.ResId = r.Id " +
                            "WHERE r.Name = 'Cafe Java'");

            System.out.println("\n---- Updating Prices <=100 to 200 ----");
            int updated = stmt.executeUpdate(
                    "UPDATE MenuItem SET Price = 200 WHERE Price <= 100");
            System.out.println("Rows Updated: " + updated);

            printResult(stmt, "SELECT * FROM MenuItem");

            System.out.println("\n---- Deleting Items starting with 'P' ----");
            int deleted = stmt.executeUpdate(
                    "DELETE FROM MenuItem WHERE Name LIKE 'P%'");
            System.out.println("Rows Deleted: " + deleted);

            printResult(stmt, "SELECT * FROM MenuItem");

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void printResult(Statement stmt, String query) throws SQLException {

        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData md = rs.getMetaData();
        int col = md.getColumnCount();

        for (int i = 1; i <= col; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}