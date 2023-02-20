package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;


import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Gestore;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.GestoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GestoreService {

    @Autowired
    private GestoreRepository gestoreRepository;


    public Optional<Gestore> controllaDati(Gestore gestore){
         Optional<Gestore> g = gestoreRepository.findById(gestore.getCodiceFiscale());
         return g;
    }

    public String salvaGestore(Gestore gestore){
        return gestoreRepository.save(gestore).getCodiceFiscale();
    }
}
