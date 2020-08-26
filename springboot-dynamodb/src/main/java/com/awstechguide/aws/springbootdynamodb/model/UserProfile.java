package com.awstechguide.aws.springbootdynamodb.model;

import com.awstechguide.aws.springbootdynamodb.domain.Task;
import com.awstechguide.aws.springbootdynamodb.domain.User;

/**
 * @author som@awstechguide.com
 *
 */
public class UserProfile {

	private String userProfileId;
	private User users;
	private Task tasks;
	
	public String getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(String userProfileId) {
		this.userProfileId = userProfileId;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Task getTasks() {
		return tasks;
	}
	public void setTasks(Task tasks) {
		this.tasks = tasks;
	}
	
	
}
