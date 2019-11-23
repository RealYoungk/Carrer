
 package com.apress.spring;
 
import java.util.Map;
import java.util.HashMap;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
//import com.mongodb.util.JSON;

public class Main {
	public static void main(String args[]) {
		System.out.print("hi");
		String MongoDB_IP = "127.0.0.1";
		int MongoDB_PORT = 27017;
		String DB_NAME = "sylas003";
		
		MongoClient mongoClient = new MongoClient(new ServerAddress(MongoDB_IP, MongoDB_PORT));
		//DB db = mongoClient.getDB(DB_NAME); //deprecated
		MongoDatabase db = mongoClient.getDatabase(DB_NAME);
		DBCollection collection = (DBCollection) db.getCollection("sylas");
		
		
		//=========BasicDBObject로 Data1 만들기========
		BasicDBObject document = new BasicDBObject();
		document.put("one", "data01");
		document.put("two", "BasicDBObject");
		
		BasicDBObject documentDetail = new BasicDBObject();
		documentDetail.put("three-one", 99);
		documentDetail.put("three-two", "BasicDBObject");
		documentDetail.put("three-three", "true");
		document.put("three",documentDetail);
		
		// 삽입
		collection.insert(document);
		
		//=========BasicDBObject로 Data2 만들기========
		BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start().add("one", "data2").add("two", "BasicDBObjectBuilder");
		BasicDBObjectBuilder documentBuilderDetail = BasicDBObjectBuilder.start().add("three-three", "false");
		documentBuilder.add("three",documentBuilderDetail.get());
		
		//삽입
		collection.insert(documentBuilder.get());
		
		//=========BasicDBObject로 Data3 만들기========
		Map<String, Object> documentMap = new HashMap<String, Object>();
		documentMap.put("one","data03");
		documentMap.put("two","Map");
		
		Map<String, Object> documentMapDetail = new HashMap<String, Object>();
		documentMapDetail.put("three-one", 97);
		documentMapDetail.put("three-two", "Map");
		documentMapDetail.put("three-three", "true");
		documentMap.put("three",documentMapDetail);
		
		//삽입
		collection.insert(new BasicDBObject(documentMap));
		
		//=========BasicDBObject로 Data4 만들기========
		String json = "{'one' : 'data4' ,'two' : 'json'," + "'three' : {'three-one' : 96, 'three-two' : 'json', 'three-three' : 'false'}}}";
		//DBObject dbObject = (DBObject)JSON.parse(json);
		DBObject dbObject = (DBObject)BasicDBObject.parse(json);
		
		//삽입
		collection.insert(dbObject);
		
		//Check Data in database
		DBCursor cursorDocBuilder = collection.find();
		while(cursorDocBuilder.hasNext()) {
			System.out.println(cursorDocBuilder.next());
		}
		
	}
}


