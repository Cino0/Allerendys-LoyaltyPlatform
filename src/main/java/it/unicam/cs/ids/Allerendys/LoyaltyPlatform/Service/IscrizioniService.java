package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Iscrizioni;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.IscrizioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IscrizioniService {

    @Autowired
    private IscrizioniRepository iscrizioniRepository;

    //TODO
    public int getNumIscritti(String idProgramma)
    {

        return 0;
    }

    public Optional<Iscrizioni> creaIscrizione(Iscrizioni iscrizione)
    {
        return iscrizioniRepository.findById(iscrizione.getId());
    }
}
