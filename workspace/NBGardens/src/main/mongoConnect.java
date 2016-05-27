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
				
				System.out.println("Connected to " + db);
				
				
				
				List<String> dbs = mongo.getDatabaseNames();
				for(String ss : dbs){
					System.out.println(ss);
					
					
					DBCollection table = db.getCollection("product");

					BasicDBObject searchQuery = new BasicDBObject();
					searchQuery.put("description", "Zombie Gnome");

					DBCursor cursor = table.find(searchQuery);

					while (cursor.hasNext()) {
						System.out.println(cursor.next());
				}
				
				
				
				
				}
				
				
				
				
		  } catch (Exception e) {
				e.printStackTrace();
}
	}
}
