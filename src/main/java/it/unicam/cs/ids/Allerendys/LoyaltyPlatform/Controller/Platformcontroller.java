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



    @PostMapping("/locale/{id}")
    public String creaLocale(@RequestBody Locale locale,@PathVariable("id") String idProprietario){
         return loyaltyPlatform.creaLocale(locale,idProprietario);
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
    @RequestMapping("/statistiche/{id}")
    public String visualizzaStatistiche(@PathVariable ("id")long idLocale )
    {
        return loyaltyPlatform.visualizzaStatistiche(idLocale);
    }

    @RequestMapping("/fattura/{id}")
    public String creaFattura(@PathVariable("id") long idLocale)
    {
        return loyaltyPlatform.creaFattura(idLocale);
    }


    @PostMapping("/propietario")
    public String creaprop(@RequestBody Proprietario proprietario){
       return loyaltyPlatform.creaUtentiSpecialiProprietatio(proprietario);
    }
    @PostMapping("/gestore")
    public String creagest(@RequestBody Gestore gestore){
        return loyaltyPlatform.creaUtentiSpecialiGestore(gestore);
    }


    @PostMapping("creac/{n}/{l}/{t}")
    public String creaCoalizione(@RequestBody Programma programma,
                                 @PathVariable("n")String nome,
                                 @PathVariable("l")long idLocale,
                                 @PathVariable("t")int tipologia){
        return loyaltyPlatform.creaCoalizione(nome,idLocale,programma,tipologia);
    }


    @RequestMapping("/coalizione/{c}/{l}")
    public String uniscitiaCoalizione(@PathVariable("c")long idCoalizione,
                                      @PathVariable("l")long idLocale){
        return loyaltyPlatform.uniscitiACoalizione(idCoalizione,idLocale);

    }


    @PostMapping("/creaD/{l}")
    public String creaDipendente(@RequestBody Dipendente dipendente,@PathVariable("l")long idLocale){
        return loyaltyPlatform.creaDipendente(idLocale,dipendente);
    }


    @PostMapping("scrivi/{l}/{c}")
    public void scriviRecensione(@RequestBody Recensione recensione,@PathVariable("l")long idLocale,@PathVariable("c")long idCliente){
        loyaltyPlatform.scriviRecensioni(idLocale,idCliente,recensione);
    }

}
