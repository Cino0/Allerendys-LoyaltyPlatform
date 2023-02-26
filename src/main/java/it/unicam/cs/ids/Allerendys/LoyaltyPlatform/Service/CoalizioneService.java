package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Coalizione;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Locale;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Tessera;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.CoalizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoalizioneService {

    @Autowired
    private CoalizioneRepository coalizioneRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Optional<Coalizione> getCoalizione(long idCoalizione)
    {
        return coalizioneRepository.findById(idCoalizione);
    }
    public long salvaCoalizione(Coalizione coalizione){
        return coalizioneRepository.save(coalizione).getId();
    }

    public void aggiungiLocale(Coalizione coalizione,long idLocale){
        Query query = new Query();
        Criteria crit = new Criteria("_id").is(coalizione.getId());
        Update update = new Update();
        query.addCriteria(crit);
        Optional<Coalizione> c = coalizioneRepository.findById(coalizione.getId());
        if (c.isPresent()){
            List<Long> l = c.get().getLocali();
            l.add(idLocale);
            update.set("locali",l);
            mongoTemplate.updateFirst(query,update, Coalizione.class);
        }
    }
}
