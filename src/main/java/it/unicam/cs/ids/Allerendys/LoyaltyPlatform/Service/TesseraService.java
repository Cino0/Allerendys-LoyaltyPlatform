package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.TesseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TesseraService {

    @Autowired
    private TesseraRepository tesseraRepository;

    public String adesioneProgramma(String idTessera)
    {
        return null;
    }
    public void VisualizzaSconti(){
    }
}
