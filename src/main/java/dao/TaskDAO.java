package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;

public class TaskDAO {
	//接続処理は共通化でいい
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	private final String DB_USER = "sa";
	private final String DBPASS = "";

	//入力したタスクをデータベースに追加
	public void AddTask(Task task) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DBPASS)) {
			String sql = "INSERT INTO TASK(USERID,TASK,PRIORITY,TASKLIMIT) VALUES(?,?,?,?) ;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, task.getUserId());
			pstmt.setString(2, task.getTask());
			pstmt.setString(3, task.getPriority());
			pstmt.setDate(4, (Date) task.getLimit());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void CompTask(int taskId) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DBPASS)) {
			String sql = "UPDATE TASK SET DEL_FLG= 1 WHERE TASKID = ? ;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, taskId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//更新処理
	public void EditTask(Task editTask) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DBPASS)) {
			String sql = "UPDATE TASK SET TASK= ?"+","+" PRIORITY = ?"+","
					+ " TASKLIMIT = ? WHERE TASKID = ? ;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, editTask.getTask());
			pstmt.setString(2, editTask.getPriority());
			pstmt.setDate(3, (Date)editTask.getLimit());
			pstmt.setInt(4, editTask.getTaskId());
			pstmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//ログインしたユーザーのタスクを取得
	public List<Task> FindTask(String id) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DBPASS)) {
			String sql = "SELECT * FROM TASK WHERE USERID = ? ;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			ArrayList<Task> taskList = new ArrayList<>();
			Task task = null;

			//idでユーザーごとのタスクを取得
			while (rs.next()) {
				task = new Task(rs.getString("TASK"), rs.getString("PRIORITY"), rs.getDate("TASKLIMIT"),rs.getInt("TASKID"),rs.getInt("DEL_FLG"));
				taskList.add(task);
			}
			return taskList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
