package com.awstechguide.aws.springbootdynamodb.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.awstechguide.aws.springbootdynamodb.domain.User;

@Repository
public class UserDetailRepository {

	private static Logger LOGGER = LoggerFactory.getLogger(UserDetailRepository.class);

	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
	DynamoDB dynamoDb = new DynamoDB(client);

	public User getUserDetails(String key) {
		Table table = dynamoDb.getTable("users");
		GetItemSpec spec = new GetItemSpec().withPrimaryKey("user_id", key);
		try {
			System.out.println("Read record");
			Item outcome = table.getItem(spec);
			if (Objects.nonNull(outcome)) {
				User user = new User();
				user.setUserId(outcome.get("user_id").toString());
				user.setUserFName(outcome.get("f_name").toString());
				user.setUserLName(outcome.get("l_name").toString());
				user.setStatus(outcome.get("status").toString());
				return user;
			}
		} catch (Exception e) {
			LOGGER.error("Exception during getUserDetails : ", e);
		}
		return null;
	}

	public String addUserDetails(User user) {
		Table table = dynamoDb.getTable("users");
		try {
			final Map<String, String> addressMap = new HashMap<String, String>();
			PutItemOutcome outcome = table.putItem(
					new Item().withPrimaryKey("user_id", user.getUserId()).with("first_name", user.getUserFName())
							.with("last_name", user.getUserLName()).withMap("address", addressMap));
			if (Objects.nonNull(outcome))
				return "SUCCESS";
			else
				return "FAILURE";
		} catch (Exception e) {
			LOGGER.error("Exception while adding record in dynamoDB : ", e);
			return null;
		}
	}

}
