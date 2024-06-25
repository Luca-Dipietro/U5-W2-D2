package lucadipietro.U5_W2_D2.services;

import lucadipietro.U5_W2_D2.entities.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogPostsService {
    private List<BlogPost> blogPostList = new ArrayList<>();

    public List<BlogPost> getBlogPostList(){
        return this.blogPostList;
    }

}
