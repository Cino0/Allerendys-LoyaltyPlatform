package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Locale;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Recensione;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.LocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocaleService {

    @Autowired
    private LocaleRepository localeRepository;


    public List<Locale> getLocali(){
        return localeRepository.findAll();
    }

    public Optional<Locale> getLocale(String idLocale){
        return localeRepository.findById(idLocale);
    }

    public String aggiungiRecensione(String idLocale, String idCliente, Recensione recensione)
    {
        Optional<Locale> l=this.getLocale(idLocale);
        if(l.isPresent())
        {
            l.get().addRecensione(recensione);
        }
        return null;

    }

}
