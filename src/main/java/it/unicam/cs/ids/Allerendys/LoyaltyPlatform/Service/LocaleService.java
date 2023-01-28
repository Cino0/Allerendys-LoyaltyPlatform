package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.LocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocaleService {

    @Autowired
    private LocaleRepository localeRepository;

}
