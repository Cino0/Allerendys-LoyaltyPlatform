package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Iscrizioni;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.IscrizioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IscrizioniService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private IscrizioniRepository iscrizioniRepository;

    public int getNumIscritti(long idProgramma)
    {
        List<Iscrizioni> i = iscrizioniRepository.findByProgramma(idProgramma);
        return 0;
    }

    public long salva(Iscrizioni iscrizione)
    {
        return iscrizioniRepository.save(iscrizione).getId();
    }

}
