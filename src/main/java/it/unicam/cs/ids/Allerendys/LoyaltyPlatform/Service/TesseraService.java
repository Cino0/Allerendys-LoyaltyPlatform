package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Iscrizioni;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Locale;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Programma;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Tessera;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.TesseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TesseraService {

    @Autowired
    private TesseraRepository tesseraRepository;

    public String adesioneProgramma(String idTessera)
    {
      return null;
    }

    public void VisualizzaSconti(){}

    public String salvaTessera(Tessera tessera){
        return tesseraRepository.save(tessera).getIdTessera();
    }
}
