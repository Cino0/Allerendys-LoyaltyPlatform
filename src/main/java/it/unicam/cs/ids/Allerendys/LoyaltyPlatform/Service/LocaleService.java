package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Locale;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Programma;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Recensione;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Sms;
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

    public Optional<Locale> getLocale(long idLocale){
        return localeRepository.findById(idLocale);
    }

    public String aggiungiRecensione(long idLocale, String idCliente, Recensione recensione)
    {
        Optional<Locale> l=this.getLocale(idLocale);
        if(l.isPresent())
        {
            l.get().addRecensione(recensione);
        }
        return null;
    }
    public String addProgramma(Programma programma, long idLocale)
    {
        Optional<Locale> l=localeRepository.findById(idLocale);
        if(l.isPresent())
        {
            l.get().getProgrammiFedelta().add(programma);
        }
        return "programma aggiunto";
    }

    public void aggiungiSms(long idLocale, Sms sms){
        Optional<Locale> l= localeRepository.findById(idLocale);
        if(l.isPresent()){
            l.get().addSms(sms);
        }
    }
}
