package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Proprietario;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.ProprietariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProprietarioService {

    @Autowired
     private ProprietariRepository proprietariRepository;


    public Optional<Proprietario> controllaDati(Proprietario proprietario){
        Optional<Proprietario> p = proprietariRepository.findById(proprietario.getCodiceFiscale());
        return p;
    }


    public String salvaProprietario(Proprietario proprietario){
        return proprietariRepository.save(proprietario).getCodiceFiscale();
    }
}
