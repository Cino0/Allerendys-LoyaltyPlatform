package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Locale;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Programma;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Recensione;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Sms;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.LocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocaleService {

    @Autowired
    private LocaleRepository localeRepository;

    @Autowired
    private MongoTemplate mongoTemplate;



    public Optional<Locale> controllaDati(Locale locale){
        return localeRepository.findById(locale.getIdLocale());
    }

    public long salva(Locale locale){
        return localeRepository.save(locale).getIdLocale();
    }

    public List<Locale> getLocali(){
        return localeRepository.findAll();
    }

    public Optional<Locale> getLocale(long idLocale){
        return localeRepository.findById(idLocale);
    }

    public String aggiungiRecensione(long idLocale, long idCliente, Recensione recensione)
    {
        Query query = new Query();
        Criteria crit = new Criteria("_id").is(idLocale);
        Update update = new Update();
        query.addCriteria(crit);
        Optional<Locale> l=this.getLocale(idLocale);
        if(l.isPresent())
        {
            l.get().addRecensione(recensione);
            List<Recensione> r= l.get().getRecensioni();
            update.set("recensioni",r);
            mongoTemplate.updateFirst(query,update,Locale.class);
        }
        return null;
    }
    public String addProgramma(Programma programma, long idLocale)
    {
        Query query = new Query();
        Criteria crit = new Criteria("_id").is(idLocale);
        Update update = new Update();
        query.addCriteria(crit);
        Optional<Locale> l=localeRepository.findById(idLocale);
        if(l.isPresent())
        {
            l.get().getProgrammiFedelta().add(programma);
            List<Programma> p = l.get().getProgrammiFedelta();
            update.set("programmiFedelta",p);
            mongoTemplate.updateFirst(query,update,Locale.class);

        }
        return "programma aggiunto";
    }

    public void aggiungiSms(long idLocale, Sms sms){
        Query query = new Query();
        Criteria crit = new Criteria("_id").is(idLocale);
        Update update = new Update();
        query.addCriteria(crit);
        Optional<Locale> l= localeRepository.findById(idLocale);
        if(l.isPresent()){
            l.get().addSms(sms);
            List<Sms> s = l.get().getCampagneSms();
            update.set("campagneSms",s);
            mongoTemplate.updateFirst(query,update,Locale.class);
        }
    }
}
