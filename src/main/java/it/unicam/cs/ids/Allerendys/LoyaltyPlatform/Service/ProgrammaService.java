package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.ProgrammaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammaService {

    @Autowired
    private ProgrammaRepository programmaRepository;
}
