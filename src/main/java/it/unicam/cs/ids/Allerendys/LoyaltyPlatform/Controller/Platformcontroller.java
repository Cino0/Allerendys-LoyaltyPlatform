package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Controller;


import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.*;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service.LoyaltyPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platform")
public class Platformcontroller {

    @Autowired
    private LoyaltyPlatform loyaltyPlatform;

    @PostMapping("/singin")
    public String registrazione(@RequestBody Cliente cliente){
        return loyaltyPlatform.registrazione(cliente);
    }

    @PostMapping("/add/{id}")
    public long registraCliente(@RequestBody Cliente cliente,@PathVariable("id") long idProgramma){
        return loyaltyPlatform.registraCliente(cliente,idProgramma);
    }

    @RequestMapping("/login/{id}")
    public String login(@PathVariable("id")String idCliennte){
        return loyaltyPlatform.login(idCliennte);
    }



    @PostMapping("/locale")
    public String creaLocale(@RequestBody Locale locale){
         return loyaltyPlatform.creaLocale(locale);
    }


    @PostMapping("/programma/{tipo}/{locale}")
    public long creaProgramma(@RequestBody Programma programma,@PathVariable("tipo") int tipo,@PathVariable("locale")long idLocale){
        return loyaltyPlatform.creaProgrammaFedelta(programma,tipo,idLocale);
    }


    @RequestMapping("acquisto/{t}/{l}/{p}/{s}")
    public String convalidaAcquisto(@PathVariable("t")long idTessera,
                                    @PathVariable("l")long idLocale,
                                    @PathVariable("p")long idProgramma,
                                    @PathVariable("s")double spesa){
        return loyaltyPlatform.convalidaAcquisto(idTessera,idLocale,idProgramma,spesa);
    }

    @GetMapping("/controllot/{t}/{l}")
    public List<Programma> controlloTessera(@PathVariable("t") long idTessera,@PathVariable("l") long idLocale){
        return loyaltyPlatform.controlloTessera(idTessera,idLocale);
    }

    @RequestMapping ("/status/{t}/{l}/{p}")
    public String visualizzaStatus(@PathVariable("t") long idTessera,
                                   @PathVariable("l") long idLocale,
                                   @PathVariable("p") long idProgramma){
        return loyaltyPlatform.visualizzaStatus(idTessera,idLocale,idProgramma);
    }


    @PostMapping("/sconti/{f}/{p}")
    public long creaSconto(@RequestBody Sconti sconto,
                           @PathVariable("f") int finialita,
                           @PathVariable("p")long idProgramma){
        return loyaltyPlatform.creaSconto(finialita,sconto,idProgramma);
    }


    @PostMapping("/sms/{l}/{f}")
    public void creaCampagnaSms(@RequestBody Sms sms,
                                @PathVariable("l")long idLocale,
                                @PathVariable("f")int finaltia){
        loyaltyPlatform.creaCampagnaSms(sms,idLocale,finaltia);

    }
}
