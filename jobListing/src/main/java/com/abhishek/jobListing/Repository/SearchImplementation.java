package com.abhishek.jobListing.Repository;

import com.abhishek.jobListing.Model.JobPost;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchImplementation implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<JobPost> findText(String text) {
        final List<JobPost> jobs = new ArrayList<JobPost>();

        MongoDatabase database = client.getDatabase("abhishek");
        MongoCollection<Document> collection = database.getCollection("jobs");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", "java")
                                        .append("path", Arrays.asList("desc", "techs", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 2L)));

        result.forEach(document -> jobs.add(converter.read(JobPost.class, document)));

        return jobs;
    }
}
