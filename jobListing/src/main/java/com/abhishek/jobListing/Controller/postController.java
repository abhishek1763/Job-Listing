package com.abhishek.jobListing.Controller;

import com.abhishek.jobListing.Model.JobPost;
import com.abhishek.jobListing.Repository.PostRepository;
import com.abhishek.jobListing.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@ApiIgnore
@RestController
public class postController
{

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository searchRepo;

    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allPost")
    public List<JobPost> getJobPost(){
        return repo.findAll();
    }

    @GetMapping("/allPost/{text}")
    public List<JobPost> search(@PathVariable String text){
//        return repo.findAll();
        return searchRepo.findText(text);
    }

    @PostMapping("/addPosts")
    public JobPost addPost(@RequestBody JobPost AddPost){
        return repo.save(AddPost);
    }
}