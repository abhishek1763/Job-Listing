Job Listing Application
This is a Spring Boot backend application for managing job listings, equipped with RESTful endpoints for CRUD operations and a text-based search functionality using MongoDB. Swagger is integrated for interactive API documentation.

Features
CRUD Operations: Create, retrieve, and manage job posts.
Text-based Search: Allows searching job listings based on keywords across multiple fields.
Swagger UI: Provides an interactive API documentation interface, accessible by default at the root URL.
MongoDB Integration: Uses MongoDB for data storage and management.
Dynamic Search Implementation: Custom search repository utilizing MongoDB's aggregation pipeline for text-based search.
Technologies Used
Spring Boot: Simplifies application setup and provides built-in support for REST APIs.
MongoDB: Used as the primary data storage, taking advantage of its flexible schema.
Swagger: Provides a UI to explore and test APIs.
Java: The main language for building application logic

PROJECT STRUCTURE :

├── Controller
│   └── postController.java       # Main REST controller with job listing endpoints.

├── Model
│   └── JobPost.java              # Data model representing job posts.

├── Repository
│   ├── PostRepository.java       # MongoDB repository for CRUD operations.

│   ├── SearchImplementation.java # Custom implementation for text-based search.

│   └── SearchRepository.java     # Interface for custom search operations.

└── JobListingApplication.java    # Main Spring Boot application file.

Endpoints
Root URL
/ - Redirects to Swagger UI for API exploration.
Job Listing Endpoints
GET /allPost - Retrieves a list of all job posts.
GET /allPost/{text} - Searches job posts based on a text query across fields desc, profile, and techs.
POST /addPosts - Adds a new job post to the database.
Data Model
The JobPost model represents the structure of a job listing:

desc: Job description (String)
exp: Experience level required (String)
profile: Job profile title (String)
techs: List of technologies related to the job (String array)
Custom Search Implementation
The SearchImplementation class provides a custom search that:

Uses MongoDB's $search functionality for full-text search.
Sorts results based on experience level (exp).
Limits results to the top 2 matches.
Getting Started
Prerequisites
Java 8 or higher
Maven for dependency management
MongoDB installed and running locally or accessible via a URI

Installation
1. Clone the repository:

git clone https://github.com/yourusername/jobListing.git
cd jobListing

2. Configure MongoDB: Update the MongoDB connection properties in application.properties if needed. Ensure the MongoDB database abhishek is accessible and has a collection named jobs.

3. Build the application:

mvn clean install

4. Run the application:
   
mvn spring-boot:run

5. Access Swagger UI: Open a browser and go to http://localhost:8080 to view and interact with the API endpoints.

Example Requests
Add a Job Post:
POST /addPosts
{
  "desc": "Backend Developer position",
  "exp": "3 years",
  "profile": "Backend Developer",
  "techs": ["Java", "Spring Boot", "MongoDB"]
}

Search Job Posts:
GET /allPost/java

This will return job posts matching the search query "java" in the description, profile, or techs fields.
