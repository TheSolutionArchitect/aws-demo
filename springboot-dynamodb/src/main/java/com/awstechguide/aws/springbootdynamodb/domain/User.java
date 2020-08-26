/**
 * 
 */
package com.awstechguide.aws.springbootdynamodb.domain;

/**
 * @author som@awstechguide.com
 *
 */
public class User {

	private String userId;
	private String userFName;
	private String userLName;
	private String status;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserFName() {
		return userFName;
	}
	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}
	public String getUserLName() {
		return userLName;
	}
	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
	
}
