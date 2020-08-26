/**
 * 
 */
package com.awstechguide.aws.springbootdynamodb.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBGeneratedUuid;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author som@awstechguide.com
 *
 */

@DynamoDBTable(tableName = "Users")
public class User {

	@DynamoDBHashKey
    @DynamoDBGeneratedUuid(DynamoDBAutoGenerateStrategy.CREATE)
	private String userId;
	
	@DynamoDBAttribute
	private String userFName;
	
	@DynamoDBAttribute
	private String userLName;
	
	@DynamoDBAttribute
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
