package com.awstechguide.aws.springbootdynamodb;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

@SpringBootApplication
public class SpringbootDynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDynamodbApplication.class, args);
		
		BasicAWSCredentials credentials = new BasicAWSCredentials("Accesskey",
				"SecretAccessKey"); 
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
		
		//final AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();
		List<Bucket> buckets = s3.listBuckets();
		buckets.stream().forEach(bucket -> {
			System.out.println("bucket name: " + bucket.getName() + " Create date: " + bucket.getCreationDate()
					+ " get Owner: " + bucket.getOwner());
		});
	}

}
