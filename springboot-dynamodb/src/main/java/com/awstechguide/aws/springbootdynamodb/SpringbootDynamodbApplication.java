package com.awstechguide.aws.springbootdynamodb;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.awstechguide.aws.springbootdynamodb.domain.Customer;
import com.awstechguide.aws.springbootdynamodb.domain.Transaction;

@SpringBootApplication
public class SpringbootDynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDynamodbApplication.class, args);
		
		AWSCredentialsProvider credentials = new AWSStaticCredentialsProvider(new BasicAWSCredentials("AccessKey",
				"SecretAccessKey")); 
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(credentials)
				.withRegion("us-east-1")
				.build();
		
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		 save(mapper);
		//load(mapper);
		 //query(mapper);
		//update(mapper);
		//delete(mapper);
	}

	public static void save(DynamoDBMapper mapper) {
		Transaction ts = new Transaction();
		ts.setTransactionNo(2);
		ts.setAmount(200);
		ts.setDate("2020-01-10");
		ts.setCustomer(Customer.builder().customerId("c1").customerName("Som").build());
		mapper.save(ts);
	}
	
	public static void load(DynamoDBMapper mapper) {
		Transaction t = new Transaction();
		t.setTransactionId("c533fb6a-f3ae-4798-bdd8-0e5077e59fed");
		Transaction result = mapper.load(t);
		System.out.println(result);
	}
	
	public static void update(DynamoDBMapper mapper) {
		// check the version filed in dynamodDB. it must have changed the version also as it changed the record
		Transaction t = new Transaction();
		t.setTransactionId("c533fb6a-f3ae-4798-bdd8-0e5077e59fed");
		Transaction result = mapper.load(t);
		result.setAmount(99);
		mapper.save(result);
		System.out.println(result);
	}
	
	public static void delete(DynamoDBMapper mapper) {
		Transaction t = new Transaction();
		t.setTransactionId("086d8b18-6758-4dd9-8890-48a0d1e75af6");
		Transaction result = mapper.load(t);
		mapper.delete(result);
	}
	
	public static void query(DynamoDBMapper mapper) {
		Transaction t = new Transaction();
		t.setTransactionId("c533fb6a-f3ae-4798-bdd8-0e5077e59fed");
		
		DynamoDBQueryExpression<Transaction> exp = new DynamoDBQueryExpression<Transaction>()
				.withHashKeyValues(t)
				.withLimit(10);
		
		List<Transaction> res = mapper.query(Transaction.class, exp);
		System.out.println(res.get(0));
	}

}
