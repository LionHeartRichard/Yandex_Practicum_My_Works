package ru.yandex.practicum.pooldatasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.PooledConnection;

import org.postgresql.ds.PGConnectionPoolDataSource;

public class AppPoolDataBaseConnection {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:6432/filmsdb";
		String user = "dbuser";
		String password = "12345";

		PGConnectionPoolDataSource ds = new PGConnectionPoolDataSource();
		ds.setURL(url);
		ds.setUser(user);
		ds.setPassword(password);
		PooledConnection pooledConnection = null;
		try {

			pooledConnection = ds.getPooledConnection();

			System.out.println("POOL__CONNECTION");
			System.out.println("Connected to PostgreSQL server successfully.");

			String sql = "SELECT * FROM films WHERE kind = ? AND len_min = ?";
			PreparedStatement preparedStatement = pooledConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, "Sci-Fi");
			preparedStatement.setInt(2, 110);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
