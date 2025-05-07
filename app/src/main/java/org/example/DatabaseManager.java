package org.example;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


import com.mongodb.client.*;

public class DatabaseManager {
    private static final String uri = "mongodb+srv://alexlharp:<db_password>@cluster0.nbvjwqw.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static MongoClient mongoClient = MongoClients.create(uri);
    private static MongoDatabase database = mongoClient.getDatabase("musicplayer");
    private static MongoCollection<Document> collection = database.getCollection("songs");

    public static void saveSongPlay(String songName) {
        Document doc = new Document("songName", songName)
                .append("playedAt", System.currentTimeMillis());
        collection.insertOne(doc);
    }
}
