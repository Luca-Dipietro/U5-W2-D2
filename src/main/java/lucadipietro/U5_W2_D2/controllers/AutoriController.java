package lucadipietro.U5_W2_D2.controllers;

import lucadipietro.U5_W2_D2.entities.Autore;
import lucadipietro.U5_W2_D2.entities.BlogPost;
import lucadipietro.U5_W2_D2.services.AutoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoriController {
    @Autowired
    private AutoriService autoriService;

    @GetMapping
    private List<Autore> getAllAutori(){
        return this.autoriService.getAutoriList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Autore saveAutore(@RequestBody Autore body){
        return this.autoriService.save(body);
    }

    @GetMapping("/{autoreId}")
    private Autore findAutoreById(@PathVariable long id){
        return this.autoriService.findById(id);
    }

    @PutMapping("/{autoreId}")
    private Autore findAndUpdateAutoreById(@PathVariable long id,@RequestBody Autore body){
        return this.autoriService.findByIdAndUpdate(id,body);
    }

    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAndDeleteAutoreById(@PathVariable long id){
        this.autoriService.findByIdAndDelete(id);
    }
}
