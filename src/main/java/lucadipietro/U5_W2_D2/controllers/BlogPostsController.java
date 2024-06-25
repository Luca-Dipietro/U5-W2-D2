package lucadipietro.U5_W2_D2.controllers;

import lucadipietro.U5_W2_D2.entities.BlogPost;
import lucadipietro.U5_W2_D2.services.BlogPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostsController {
    @Autowired
    private BlogPostsService blogPostsService;

    @GetMapping
    private List<BlogPost> getAllBlogPost(){
        return this.blogPostsService.getBlogPostList();
    }
}
