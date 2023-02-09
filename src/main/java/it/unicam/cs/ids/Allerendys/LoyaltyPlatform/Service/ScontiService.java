package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.ProgrammaRepository;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.TesseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScontiService {

    @Autowired
    private TesseraRepository tesseraRepository;

    private ProgrammaRepository programmaRepository;

    public boolean controllaSconto(String idSconto)
    {

        return true;
    }
}
