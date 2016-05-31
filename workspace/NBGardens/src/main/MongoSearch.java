/*package main;

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


import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;


public class MongoSearch {

	public static void main(String[] args) {
	
	

				*//**** Connect to MongoDB ****//*
				// Since 2.10.0, uses MongoClient
				MongoClient mongo = new MongoClient(new ServerAddress("192.168.1.149", 27017));

				*//**** Get database ****//*
				// if database doesn't exists, MongoDB will create it for you
				DB db = mongo.getDB("product");
				DBCollection product = db.getCollection("product");
				System.out.println(product.toString());
				System.out.println("Connected to " + db + product);
				System.out.println();
				
				DBCursor cursor = product.find(new BasicDBObject("Name", "Zombie Gnome"));
				
				

				while (cursor.hasNext());
				
					System.out.println(cursor.next());
				
		  		}
		  
		
		  
	}*/