package lucadipietro.U5_W2_D2.services;

import lucadipietro.U5_W2_D2.entities.Autore;
import lucadipietro.U5_W2_D2.entities.BlogPost;
import lucadipietro.U5_W2_D2.exceptions.NotFoundException;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AutoriService {
    private List<Autore> autoriList = new ArrayList<>();

    public List<Autore> getAutoriList(){
        return this.autoriList;
    }

    public Autore save(Autore body){
        Random rnd = new Random();
        body.setId(rnd.nextLong(1,100));
        body.setDataDiNascita(LocalDate.of(rnd.nextInt(1980,2006),rnd.nextInt(1,12), rnd.nextInt(1,31)));
        body.setAvatar("https://ui-avatars.com/api/?name="+body.getNome()+body.getCognome());
        this.autoriList.add(body);
        return body;
    }

    public Autore findById(long id){
        Autore found = null;
        for(Autore autore:this.autoriList){
            if(autore.getId() == id){
                found = autore;
            }
        }
        if(found == null){
            throw new NotFoundException(id);
        }else {
            return found;
        }
    }

    public Autore findByIdAndUpdate(long id,Autore updateAutore){
        Autore found = null;
        for(Autore autore :this.autoriList){
            if(autore.getId() == id){
                found = autore;
                found.setNome(updateAutore.getNome());
                found.setCognome(updateAutore.getCognome());
                found.setEmail(updateAutore.getEmail());
                found.setDataDiNascita(updateAutore.getDataDiNascita());
            }
        }
        if(found == null){
            throw new NotFoundException(id);
        }else {
            return found;
        }
    }

    public void findByIdAndDelete(long id) {
        Iterator<Autore> iterator = this.autoriList.iterator();
        while (iterator.hasNext()) {
            Autore current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
