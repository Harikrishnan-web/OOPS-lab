import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb","root","password");
            System.out.println("Connected");
            
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            
            boolean found = false;
            while(rs.next()) {
                found = true;
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
            if(!found) System.out.println("No results");

            c.close();
        } 
        catch(SQLException e) {
            System.out.println(e.getMessage());
        } 
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
