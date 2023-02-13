package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Dipendente;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.DipendeteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DipendeteService {

    @Autowired
    private DipendeteRepository dipendeteRepository;


    public String salvaDipendete(Dipendente dipendente){
       return dipendeteRepository.save(dipendente).getIdDipendente();
    }


    public Optional<Dipendente> controllaDati(Dipendente dipendente){
        Optional<Dipendente> d = dipendeteRepository.findById(dipendente.getIdDipendente());
        return d;
    }
}
