package lucadipietro.U5_W2_D2.services;

import lucadipietro.U5_W2_D2.entities.BlogPost;
import lucadipietro.U5_W2_D2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostsService {
    private List<BlogPost> blogPostList = new ArrayList<>();

    public List<BlogPost> getBlogPostList(){
        return this.blogPostList;
    }

    public BlogPost save(BlogPost body){
        Random rnd = new Random();
        body.setId(rnd.nextLong(1,100));
        body.setCover("https://picsum.photos/" + rnd.nextInt(1,300) + "/" + rnd.nextInt(1,300));
        body.setTempoDiLettura(rnd.nextInt(1,30));
        this.blogPostList.add(body);
        return body;
    }

    public BlogPost findById(long id){
        BlogPost found = null;
        for(BlogPost blogPost:this.blogPostList){
            if(blogPost.getId() == id){
                found = blogPost;
            }
        }
        if(found == null){
            throw new NotFoundException(id);
        }else {
            return found;
        }
    }

    public BlogPost findByIdAndUpdate(long id,BlogPost updateBlogPost){
        BlogPost found = null;
        for(BlogPost blogPost:this.blogPostList){
            if(blogPost.getId() == id){
                found = blogPost;
                found.setCategoria(updateBlogPost.getCategoria());
                found.setTitolo(updateBlogPost.getTitolo());
                found.setCover(updateBlogPost.getCover());
                found.setContenuto(updateBlogPost.getContenuto());
                found.setTempoDiLettura(updateBlogPost.getTempoDiLettura());
            }
        }
        if(found == null){
            throw new NotFoundException(id);
        }else {
            return found;
        }
    }

    public void findByIdAndDelete(long id) {
        Iterator<BlogPost> iterator = this.blogPostList.iterator();
        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
