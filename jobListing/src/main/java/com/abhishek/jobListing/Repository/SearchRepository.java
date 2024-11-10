package com.abhishek.jobListing.Repository;

import com.abhishek.jobListing.Model.JobPost;

import java.util.List;

public interface SearchRepository {
    List<JobPost> findText(String text);
}
