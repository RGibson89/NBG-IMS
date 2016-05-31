package main;

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


public class mongoConnect {

	public static void main(String[] args) {
	
		  try {

				/**** Connect to MongoDB ****/
				// Since 2.10.0, uses MongoClient
				MongoClient mongo = new MongoClient(new ServerAddress("192.168.1.149", 27017));

				/**** Get database ****/
				// if database doesn't exists, MongoDB will create it for you
				DB db = mongo.getDB("product");
				DBCollection product = db.getCollection("product");
				
				BasicDBObject whereQuery = new BasicDBObject();
		        whereQuery.put("Name", 5);
		        BasicDBObject fields = new BasicDBObject();
		        fields.put("Name", "Gnome");
				
				DBCursor cursor = product.find(whereQuery, fields);
		        while(cursor.hasNext()) {
		            System.out.println(cursor.next());
		        }
				
				System.out.println("Connected to " + db);
						
		  } catch (Exception e) {
				e.printStackTrace();
}
	}
}