package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Controller;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service.TesseraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tessera" )
public class TesseraController {

    @Autowired
    private TesseraService tesseraService;

    @RequestMapping ("/adesione/{id}/{programma}")
    public String adesioneProgramma(@PathVariable("id") long idTessera,@PathVariable("programma") long idProgramma){
        return tesseraService.adesioneProgramma(idTessera,idProgramma);
    }

    @RequestMapping("/sconti/{id}")
    public String visualizzaSconti(@PathVariable("id")long idTessera){
        return tesseraService.VisualizzaSconti(idTessera);
    }

    @RequestMapping("{idTessera}/programma/{id}")
    public String visualizzaPunti(@PathVariable("idTessera")long idTessera)
    {
        return tesseraService.VisualizzaPunti(idTessera);
    }
    @RequestMapping("{idTessera}/programma{id}")
    public String visualizzaLivello(@PathVariable("idTessera")long idTessera)
    {
        return tesseraService.VisualizzaLivello(idTessera);
    }
}
