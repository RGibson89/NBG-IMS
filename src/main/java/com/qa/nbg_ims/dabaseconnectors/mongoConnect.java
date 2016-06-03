package com.qa.nbg_ims.dabaseconnectors;

import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.*;
import java.util.regex.Pattern;
import java.util.List;
import java.util.logging.Logger;


import static java.util.concurrent.TimeUnit.SECONDS;

public class mongoConnect {

	public static void main(String[] args) {

		try {
			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient(new ServerAddress("192.168.1.149", 27017));

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("product");

			//System.out.println("Connected to " + db);

			/**List<String> dbs = mongo.getDatabaseNames();
			
				for(String ss : dbs){
					
					System.out.println(ss);
				}**/
				
				
		DBCollection coll = db.getCollection("product");
		
		System.out.println("Would you like to search by: Product Name or Description?");
		
		Scanner userInput = new Scanner(System.in);
		String search = userInput.nextLine();
		
		System.out.println("Please enter your search:");
		
		String searchInput = userInput.nextLine();
		
		DBObject searchObject = new BasicDBObject();
		searchObject.put("text", "Gnome");
		DBObject explainObject = db.getCollection("products").find(searchObject).explain();
		System.out.println(explainObject);
		
		//DBObject myDoc = coll.findOne();
		//System.out.println(myDoc);
		
		//System.out.println(coll.getCount());

		DBCollection table = db.getCollection("product");
		
		Pattern p = Pattern.compile(searchInput+".*");
		BasicDBObject query = new BasicDBObject(search, p);
		 
		//BasicDBObject query = new BasicDBObject("Description", "$Jac");
		DBCursor cursor = coll.find(query);

		try {
			   while(cursor.hasNext()) {
			       System.out.println(cursor.next());
			   }
			} finally {
			   cursor.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
