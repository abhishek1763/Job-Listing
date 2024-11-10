package com.abhishek.jobListing.Repository;

import com.abhishek.jobListing.Model.JobPost;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<JobPost, String>
{

}
