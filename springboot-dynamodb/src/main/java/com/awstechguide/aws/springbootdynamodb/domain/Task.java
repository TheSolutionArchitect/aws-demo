package com.awstechguide.aws.springbootdynamodb.domain;
/**
 * @author som@awstechguide.com
 *
 */
public class Task {

	private String taskId;
	private String taskTitle;
	private String taskDesc;
	private String taskStatus;
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskTitle=" + taskTitle + ", taskDesc=" + taskDesc + ", taskStatus="
				+ taskStatus + "]";
	}
	
	
}
