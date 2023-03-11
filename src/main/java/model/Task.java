package model;

import java.io.Serializable;
import java.sql.Date;

public class Task implements Serializable {
	private String userId, task, priority;
	private Date limit;
	private int taskId,delFlg;

	public Task(String userId,String task, String priority, Date limit) {
		this.userId = userId;
		this.task = task;
		this.priority = priority;
		this.limit = limit;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Task(String task, String priority, Date limit,int taskId,int delFlg) {
		this.task = task;
		this.priority = priority;
		this.limit = limit;
		this.taskId = taskId;
		this.delFlg = delFlg;
	}

	public int getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(int delFlg) {
		this.delFlg = delFlg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getLimit() {
		return limit;
	}

	public void setLimit(Date limit) {
		this.limit = limit;
	}
}
