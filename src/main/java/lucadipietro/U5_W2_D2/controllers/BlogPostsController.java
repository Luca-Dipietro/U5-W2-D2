package lucadipietro.U5_W2_D2.controllers;

import lucadipietro.U5_W2_D2.entities.BlogPost;
import lucadipietro.U5_W2_D2.services.BlogPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {
    @Autowired
    private BlogPostsService blogPostsService;

    @GetMapping
    private List<BlogPost> getAllBlogPost(){
        return this.blogPostsService.getBlogPostList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost saveBlogPost(@RequestBody BlogPost body){
        return this.blogPostsService.save(body);
    }

    @GetMapping("/{blogPostId}")
    private BlogPost findBlogPostById(@PathVariable long id){
        return this.blogPostsService.findById(id);
    }

    @PutMapping("/{blogPostId}")
    private BlogPost findAndUpdateBlogPostById(@PathVariable long id,@RequestBody BlogPost body){
        return this.blogPostsService.findByIdAndUpdate(id,body);
    }

    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAndDeleteBlogPostById(@PathVariable long id){
        this.blogPostsService.findByIdAndDelete(id);
    }
}
