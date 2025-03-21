package ru.yandex.practicum.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:6432/filmsdb";
		String user = "dbuser";
		String password = "12345";

		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			System.out.println("Connected to PostgreSQL server successfully.");

			Statement stmt = conn.createStatement();
//			String createTableQuery = "CREATE TABLE users (" + "id INT PRIMARY KEY NOT NULL, " + "name TEXT NOT NULL, "
//					+ "age INT NOT NULL, " + "city TEXT NOT NULL);";
			String insertQuery = "INSERT INTO users (id, name, age, city) VALUES (2, 'Tot', 9, 'Gufffff')";

//			stmt.executeUpdate(createTableQuery);
			stmt.executeUpdate(insertQuery);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
