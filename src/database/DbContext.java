package database;

import services.AuditService;

import java.sql.*;


public class DbContext {

    private static Connection con;

    public DbContext() {
    }

    AuditService auditService = new AuditService();

    public static Connection getInstace(String database, String user, String password) {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, password);
                if (con != null) {
                    System.out.println("Connected to the database");
                } else {
                    System.out.println("Failed to connect to the database");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

            }


        }
        return con;
    }


    public void CreateTable(Connection con, String tableName) {
        try {
            if (tableName.equalsIgnoreCase("actor")) {
                String query = "CREATE TABLE IF NOT EXISTS actor (actorid SERIAL PRIMARY KEY, firstname VARCHAR(50), lastname VARCHAR(50), birthdate DATE, alive BOOLEAN)";
                con.createStatement().execute(query);
                System.out.println("Table created successfully");

            } else if (tableName.equalsIgnoreCase("movie")) {
                String query = "CREATE TABLE IF NOT EXISTS movie (movieid SERIAL PRIMARY KEY, title VARCHAR(50), release_date DATE, duration INT, genre VARCHAR(50))";
                con.createStatement().execute(query);
                System.out.println("Table created successfully");

            } else if (tableName.equalsIgnoreCase("genre")) {
                String query = "CREATE TABLE IF NOT EXISTS genre (genreid SERIAL PRIMARY KEY, name VARCHAR(50))";
                con.createStatement().execute(query);
            } else if (tableName.equalsIgnoreCase("director")) {
                String query = "CREATE TABLE IF NOT EXISTS director (directorid SERIAL PRIMARY KEY, firstname VARCHAR(50), lastname VARCHAR(50), birthdate DATE, alive BOOLEAN)";
                con.createStatement().execute(query);
                System.out.println("Table created successfully");
            }


        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            auditService.addLog("Create table " + tableName);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try{
            auditService.addLog("Create table " + tableName);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }


    }
    public void InsertValues(Connection con, String tableName, String[] values) {
        String query = "";
        switch (tableName.toLowerCase()) {
            case "actor":
                query = "INSERT INTO actor (firstname, lastname, birthdate, alive) VALUES (?, ?, ?, ?)";
                break;
            case "director":
                query = "INSERT INTO director (firstname, lastname, birthdate, alive) VALUES (?, ?, ?, ?)";
                break;
            case "movie":
                query = "INSERT INTO movie (title, release_date, duration, genre) VALUES (?, ?, ?, ?)";
                break;
            case "genre":
                query = "INSERT INTO genre (name) VALUES (?)";
                break;
            default:
                System.out.println("Invalid table name");
                return;
        }

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                pstmt.setString(i + 1, values[i]);
            }
            pstmt.executeUpdate();
            System.out.println("Values inserted successfully into " + tableName);
            auditService.addLog("Insert values into " + tableName);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void UpdateValues(Connection con, String tableName, String column, String value, String condition) {



        String query = "UPDATE " + tableName + " SET " + column + " = ? WHERE " + condition;
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            // Check if the value can be parsed as an integer
            try {
                int intValue = Integer.parseInt(value);
                pstmt.setInt(1, intValue);
            } catch (NumberFormatException e1) {
                // Check if the value can be parsed as a boolean
                if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
                    boolean boolValue = Boolean.parseBoolean(value);
                    pstmt.setBoolean(1, boolValue);
                } else {
                    // Otherwise, treat it as a string
                    pstmt.setString(1, value);
                }
            }
            pstmt.executeUpdate();
            System.out.println("Values updated successfully");
            auditService.addLog("Update values in " + tableName);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void Select(Connection con, String tableName)
    {
        ResultSet input = null;
        try {
            String query = "SELECT * FROM " + tableName;
            input = con.createStatement().executeQuery(query);
            while (input.next()) {
                if (tableName.equalsIgnoreCase("actor")) {
                    System.out.println("Actor ID: " + input.getInt("actorid"));
                    System.out.println("First Name: " + input.getString("firstname"));
                    System.out.println("Last Name: " + input.getString("lastname"));
                    System.out.println("Birth Date: " + input.getDate("birthdate"));
                    System.out.println("Alive: " + input.getBoolean("alive"));
                    System.out.println("----------------------------------------------");
                } else if (tableName.equalsIgnoreCase("movie")) {
                    System.out.println("Movie ID: " + input.getInt("movieid"));
                    System.out.println("Title: " + input.getString("title"));
                    System.out.println("Release Date: " + input.getDate("release_date"));
                    System.out.println("Duration: " + input.getInt("duration"));
                    System.out.println("Genre: " + input.getString("genre"));
                    System.out.println("----------------------------------------------");
                }  else if (tableName.equalsIgnoreCase("genre")) {
                    System.out.println("Genre ID: " + input.getInt("genreid"));
                    System.out.println("Name: " + input.getString("name"));
                    System.out.println("----------------------------------------------");
                } else if (tableName.equalsIgnoreCase("director")) {
                    System.out.println("Director ID: " + input.getInt("directorid"));
                    System.out.println("First Name: " + input.getString("firstname"));
                    System.out.println("Last Name: " + input.getString("lastname"));
                    System.out.println("Birth Date: " + input.getDate("birthdate"));
                    System.out.println("Alive: " + input.getBoolean("alive"));
                    System.out.println("----------------------------------------------");
                }
            }
            System.out.println("Values selected successfully");
        }
                catch (SQLException e){
                    System.out.println("Error: " + e.getMessage());
                }
                try{
                    auditService.addLog("Select values from " + tableName);
                } catch (Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
    }
    public void DeleteValues(Connection con, String tableName, String condition)
    {
        try{
            String query = "DELETE FROM " + tableName + " WHERE " + condition;
            con.createStatement().execute(query);
            System.out.println("Values deleted successfully");
        }
        catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        try{
            auditService.addLog("Delete values from " + tableName);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void DropTable(Connection con, String tableName)
    {
        try{
            String query = "DROP TABLE " + tableName;
            con.createStatement().execute(query);
            System.out.println("Table dropped successfully");
        }
        catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        try{
            auditService.addLog("Drop table " + tableName);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void ListTables(Connection con)
    {
        try{
            String query = "SHOW TABLES";
            ResultSet input = con.createStatement().executeQuery(query);
            while (input.next()){
                System.out.println(input.getString("Tables_in_cinema"));
            }
        }
        catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void selectOrderedTable(Connection con, String tableName)
    {
        ResultSet input = null;
        try{
            if (tableName.equalsIgnoreCase("actor"))
            {
                String query = "SELECT * FROM actor ORDER BY firstname";
                input = con.createStatement().executeQuery(query);
                while (input.next())
                {
                    System.out.println("Actor ID: " + input.getInt("actorid"));
                    System.out.println("First Name: " + input.getString("firstname"));
                    System.out.println("Last Name: " + input.getString("lastname"));
                    System.out.println("Birth Date: " + input.getDate("birthdate"));
                    System.out.println("Alive: " + input.getBoolean("alive"));
                    System.out.println("----------------------------------------------");

            }
            }
            else if (tableName.equalsIgnoreCase("movie"))
            {
                String query = "SELECT * FROM movie ORDER BY title";
                input = con.createStatement().executeQuery(query);
                while (input.next())
                {
                    System.out.println("Movie ID: " + input.getInt("movieid"));
                    System.out.println("Title: " + input.getString("title"));
                    System.out.println("Release Date: " + input.getDate("release_date"));
                    System.out.println("Duration: " + input.getInt("duration"));
                    System.out.println("Genre: " + input.getString("genre"));
                    System.out.println("----------------------------------------------");
                }
            }
            else if (tableName.equalsIgnoreCase("genre"))
            {
                String query = "SELECT * FROM genre ORDER BY name";
                input = con.createStatement().executeQuery(query);
                while (input.next())
                {
                    System.out.println("Genre ID: " + input.getInt("genreid"));
                    System.out.println("Name: " + input.getString("name"));
                    System.out.println("----------------------------------------------");
                }
            }
            else if (tableName.equalsIgnoreCase("director"))
            {
                String query = "SELECT * FROM director ORDER BY firstname";
                input = con.createStatement().executeQuery(query);
                while (input.next())
                {
                    System.out.println("Director ID: " + input.getInt("directorid"));
                    System.out.println("First Name: " + input.getString("firstname"));
                    System.out.println("Last Name: " + input.getString("lastname"));
                    System.out.println("Birth Date: " + input.getDate("birthdate"));
                    System.out.println("Alive: " + input.getBoolean("alive"));
                    System.out.println("----------------------------------------------");
                }
            }
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void createDatabase(Connection connection) {
        try {
            String query = "CREATE DATABASE IF NOT EXISTS cinema";
            connection.createStatement().execute(query);
            System.out.println("Database created successfully");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            auditService.addLog("Create database cinema");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void dropDatabase(Connection connection) {
        try {
            String query = "DROP DATABASE IF EXISTS cinema";
            connection.createStatement().execute(query);
            System.out.println("Database dropped successfully");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            auditService.addLog("Drop database cinema");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void listDatabases(Connection con) {
        try {
            String query = "SHOW DATABASES";
            ResultSet input = con.createStatement().executeQuery(query);
            while (input.next()) {
                System.out.println(input.getString("Database"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void PrintColumns(Connection con, String table) {
        try {
            String query = "SELECT * FROM " + table;
            ResultSet input = con.createStatement().executeQuery(query);
            ResultSetMetaData rsmd = input.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print(rsmd.getColumnName(i) + " ");
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}

