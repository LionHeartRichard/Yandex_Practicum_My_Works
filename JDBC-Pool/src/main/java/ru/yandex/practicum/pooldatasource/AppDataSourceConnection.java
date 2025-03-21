package ru.yandex.practicum.pooldatasource;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.ds.PGSimpleDataSource;

public class AppDataSourceConnection {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:6432/filmsdb";
		String user = "dbuser";
		String password = "12345";

		PGSimpleDataSource ds = new PGSimpleDataSource();
		ds.setURL(url);
		ds.setUser(user);
		ds.setPassword(password);
		try (Connection conn = ds.getConnection()) {
			System.out.println("DATA-SOURCE");
			System.out.println("Connected to PostgreSQL server successfully.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
