package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Locale;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Programma;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Sconti;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.ProgrammaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammaService {


    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private ProgrammaRepository programmaRepository;


    public long salva(Programma programma){
        return programmaRepository.save(programma).getIdProgramma();
    }


    public List<Programma> getProgrammi(){
        return programmaRepository.findAll();
    }

    public Optional<Programma> getPrograma(long idProgramma){
        return programmaRepository.findById(idProgramma);
    }


    public void aggiungiScontoaProgramma(Sconti sconto,long idProgramma){
        Query query = new Query();
        Criteria crit = new Criteria("_id").is(idProgramma);
        Update update = new Update();
        query.addCriteria(crit);
        Optional<Programma> p =programmaRepository.findById(idProgramma);
        if (p.isPresent()){
            p.get().addSconti(sconto);
            List<Sconti> s = p.get().getSconti();
            update.set("sconti",s);
            mongoTemplate.updateFirst(query,update, Programma.class);
        }
    }
}
