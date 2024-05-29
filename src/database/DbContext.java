package database;

import services.AuditService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


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
                String query = "CREATE TABLE IF NOT EXISTS movie (movieid SERIAL PRIMARY KEY, title VARCHAR(50), release_date DATE, duration INT, genre VARCHAR(50), directorid INT, FOREIGN KEY (directorid) REFERENCES director(directorid))";
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
            else if (tableName.equalsIgnoreCase("theater")) {
                String query = "CREATE TABLE IF NOT EXISTS theater (theaterid SERIAL PRIMARY KEY, no_seats INT)";
                con.createStatement().execute(query);
                System.out.println("Table created successfully");
            }
            else if (tableName.equalsIgnoreCase("ticket")){
                String query = "CREATE TABLE IF NOT EXISTS ticket (ticketid SERIAL PRIMARY KEY, price INT, movieid INT, theaterid INT, FOREIGN KEY (movieid) REFERENCES movie(movieid), FOREIGN KEY (theaterid) REFERENCES theater(theaterid))";
                con.createStatement().execute(query);
                System.out.println("Table created successfully");
            }
            else if (tableName.equalsIgnoreCase("client")){
                String query = "CREATE TABLE IF NOT EXISTS client (clientid SERIAL PRIMARY KEY, firstname VARCHAR(50), lastname VARCHAR(50), email VARCHAR(50), phone VARCHAR(50))";
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
    public void InsertValues(Connection con, String tableName, String values)
    {
        try{
            String query = "INSERT INTO " + tableName + " VALUES (" + values + ")";
            con.createStatement().execute(query);
            System.out.println("Values inserted successfully");
        }
        catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        try{
            auditService.addLog("Insert values into " + tableName);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void UpdateValues(Connection con, String tableName, String column, String value, String condition)
    {
        try{
            String query = "UPDATE " + tableName + " SET " + column + " = " + value + " WHERE " + condition;
            con.createStatement().execute(query);
            System.out.println("Values updated successfully");
        }
        catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        try{
            auditService.addLog("Update values in " + tableName);
        } catch (Exception e){
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
                } else if (tableName.equalsIgnoreCase("movie")) {
                    System.out.println("Movie ID: " + input.getInt("movieid"));
                    System.out.println("Title: " + input.getString("title"));
                    System.out.println("Release Date: " + input.getDate("release_date"));
                    System.out.println("Duration: " + input.getInt("duration"));
                    System.out.println("Genre: " + input.getString("genre"));
                    System.out.println("Director ID: " + input.getInt("directorid"));
                }  else if (tableName.equalsIgnoreCase("genre")) {
                    System.out.println("Genre ID: " + input.getInt("genreid"));
                    System.out.println("Name: " + input.getString("name"));
                } else if (tableName.equalsIgnoreCase("director")) {
                    System.out.println("Director ID: " + input.getInt("directorid"));
                    System.out.println("First Name: " + input.getString("firstname"));
                    System.out.println("Last Name: " + input.getString("lastname"));
                    System.out.println("Birth Date: " + input.getDate("birthdate"));
                    System.out.println("Alive: " + input.getBoolean("alive"));
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
}

