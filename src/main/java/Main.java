import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Making url DB
        String url = "jdbc:sqlite:C:/Dev/sqlite/westeros.db";
        
        //Making source, setting url in there
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);
        
        System.out.println("Just checking");

        //Establishing connection
        try (Connection con = dataSource.getConnection()) {
            // Statement creation
            try (Statement statement = con.createStatement()) {
                // Statement execution
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS HOUSES(" +
                        "id INTEGER PRIMARY KEY," +
                        "name TEXT NOT NULL," +
                        "words TEXT NOT NULL)");  
            } catch (SQLException e) {
                System.out.println("SQL Disaster");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("SQL Disaster");
            e.printStackTrace();
        }
    }
}


