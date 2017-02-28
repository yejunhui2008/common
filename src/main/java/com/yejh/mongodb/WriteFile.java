package com.yejh.mongodb;

import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSUploadStream;

public class WriteFile {

	private MongoClient mongoClient;

	@Test
	public void testMongodb() {
		String filename = "test1";
		mongoClient = new MongoClient("10.1.50.139", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");

		GridFSBucket gfsb = GridFSBuckets.create(db, "admin");
		GridFSUploadStream us = gfsb.openUploadStream(filename);
		us.write("123".getBytes());
		us.close();
	}
}
