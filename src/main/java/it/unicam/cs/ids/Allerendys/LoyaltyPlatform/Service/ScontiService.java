package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Sconti;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.ProgrammaRepository;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.ScontiRepository;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.TesseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScontiService {

    @Autowired
    private ScontiRepository scontiRepository;


    public Optional<Sconti> controllaSconto(String idSconto)
    {
        Optional<Sconti> sconti= scontiRepository.findById(idSconto);
        return sconti;
    }


    public void salvaSconto(Sconti sconto){
        this.scontiRepository.save(sconto);
    }
}
