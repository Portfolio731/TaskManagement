package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.User;

public class UserDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	private final String DB_USER = "sa";
	private final String DBPASS = "";
	DataSource data;

	public boolean Login(User user) {
		boolean loginResult = false;
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DBPASS)) {
			String sql = "SELECT ID,PASS FROM USER_DATA WHERE ID = ? AND PASS =?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());

			ResultSet rs = pstmt.executeQuery();
			//入力した値とidとパスワードが一致したらログイン完了
			while (rs.next()) {
				String userId = rs.getString("ID");
				String pass = rs.getString("PASS");
				if (user.getId().equals(userId)  && user.getPass().equals(pass)) {
					loginResult = true;
					return loginResult;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginResult;
	}
}
