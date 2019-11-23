/*
package com.apress.spring;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

//*****Connection DB, Collection information confirm

public class JavaMongoApplication{
	public static void main(String args[]) {
		String MongoDB_IP = "127.0.0.1";
		int MongoDB_PORT = 27017;
		String DB_NAME = "sylas003";
		
		MongoClient mongoClient = new MongoClient(new ServerAddress(MongoDB_IP, MongoDB_PORT));
		

		//List<String> databases = mongoClient.getDatabaseNames();
		//->더이상 사용할 수 없음
		//Set<String> databases = null;
		List<String> databases = new ArrayList<String>();
		MongoCursor<String> dbsCursor = mongoClient.listDatabaseNames().iterator();
		while(dbsCursor.hasNext()) {
			String database = dbsCursor.next();
			//System.out.println(dbsCursor.next());
			databases.add(database);
		}
		
		System.out.println("====Database List====");
		int num = 1;
		for(String dbName : databases) {
			System.out.println(num + ". " + dbName);
			num++;
		}
		
		System.out.println();
		
		//디비연결, 디비에 컬렉션 보기
		// Db db = mongoClient.getDB(DB_NAME); deprecated
		MongoDatabase db = mongoClient.getDatabase(DB_NAME);
		//Set<String> collections = db.getCollectionNames();
		MongoCursor<String> colCursor = db.listCollectionNames().iterator();
		//MongoCursor<String> colCursor = mongoClient.listCollectionNames().iterator();
		//Set<String> collections = null;
		List<String> collections = new ArrayList<String>();
		while(colCursor.hasNext()) {
			String collection = colCursor.next();
			collections.add(collection);
		}
		
		System.out.println("Database : " + DB_NAME);
		for(String colName : collections) {
			System.out.println(" + Collection: " + colName);
		}
	}
}


*/