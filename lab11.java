import java.sql.*;
public class Lab11
{
    String JDBC_URL = "jdbc:mysql://localhost:3306/student_database";
    String USERNAME = "root";
    String PASSWORD = "hello";
    public static void main(String[] args)
    {
        Lab11 app = new Lab11();

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(app.JDBC_URL, app.USERNAME, app.PASSWORD))
            {
                System.out.println("Connected to the database.");

                app.insert(con, "Amogh", "Brahma", 20, "ISE");
                app.display(con);
                app.update(con, 1, "Brahma", "Amogh", 26, "CSE");
                app.searchID(con, 1);
                app.delete(con, 1);
                app.searchName(con, "Amogh");
                app.display(con);
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    void insert(Connection con, String fn, String ln, int age, String department) throws SQLException
    {
        String IQ = "INSERT INTO Student (first_name, last_name, age, department) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(IQ, Statement.RETURN_GENERATED_KEYS))
        {
            ps.setString(1, fn);
            ps.setString(2, ln);
            ps.setInt(3, age);
            ps.setString(4, department);
            int rows = ps.executeUpdate();
            if (rows > 0)
            {
                try (ResultSet rs = ps.getGeneratedKeys())
                {
                    if (rs.next())
                    {
                        System.out.println("A new student record was inserted successfully!");
                        System.out.println("Inserted student ID: " + rs.getInt(1));
                    }
                }
            }
        }
    }

    void update(Connection con, int studentId, String fn, String ln, int age, String department) throws SQLException
    {
        String checkQuery = "SELECT * FROM Student WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(checkQuery))
        {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                {
                    System.out.println("Student record with ID " + studentId + " exists. Proceeding with update.");

                    String updateQuery = "UPDATE Student SET first_name=?, last_name=?, age=?, department=? WHERE id=?";
                    try (PreparedStatement updatePs = con.prepareStatement(updateQuery))
                    {
                        updatePs.setString(1, fn);
                        updatePs.setString(2, ln);
                        updatePs.setInt(3, age);
                        updatePs.setString(4, department);
                        updatePs.setInt(5, studentId);

                        int rows = updatePs.executeUpdate();
                        if (rows > 0)
                        {
                            System.out.println("Student record with ID " + studentId + " was updated successfully!");
                        }
                        else
                        {
                            System.out.println("No record was updated. Check your input values.");
                        }
                    }
                }
                else
                {
                    System.out.println("No student record found with ID " + studentId);
                }
            }
        }
    }

    void delete(Connection con, int studentId) throws SQLException
    {
        String DQ = "DELETE FROM Student WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(DQ))
        {
            ps.setInt(1, studentId);
            int rows = ps.executeUpdate();
            if (rows > 0)
            {
                System.out.println("Student record with ID " + studentId + " was deleted successfully!");
            }
            else
            {
                System.out.println("No student record found with ID " + studentId);
            }
        }
    }

    void searchName(Connection con, String fn) throws SQLException
    {
        String SQ = "SELECT * FROM Student WHERE first_name=?";
        try (PreparedStatement ps = con.prepareStatement(SQ))
        {
            ps.setString(1, fn);
            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                {
                    System.out.println("Student found:");
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("First Name: " + rs.getString("first_name"));
                    System.out.println("Last Name: " + rs.getString("last_name"));
                    System.out.println("Age: " + rs.getInt("age"));
                    System.out.println("Department: " + rs.getString("department"));
                }
                else
                {
                    System.out.println("No student found with first name: " + fn);
                }
            }
        }
    }

    void searchID(Connection con, int studentId) throws SQLException
    {
        String SQ = "SELECT * FROM Student WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(SQ))
        {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                {
                    System.out.println("Updated student found:");
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("First Name: " + rs.getString("first_name"));
                    System.out.println("Last Name: " + rs.getString("last_name"));
                    System.out.println("Age: " + rs.getInt("age"));
                    System.out.println("Department: " + rs.getString("department"));
                }
                else
                {
                    System.out.println("No student found with ID: " + studentId);
                }
            }
        }
    }

    void display(Connection con) throws SQLException
    {
        String Q = "SELECT * FROM Student";
        try (Statement statement = con.createStatement(); ResultSet rs = statement.executeQuery(Q))
        {
            while (rs.next())
            {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("First Name: " + rs.getString("first_name"));
                System.out.println("Last Name: " + rs.getString("last_name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("----------------------");
            }
        }
    }
}
