package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Controller;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Tessera;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service.TesseraService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tessera" )
public class TesseraController {

    @Autowired
    private TesseraService tesseraService;



    @GetMapping("/{id}")
    public Tessera getT(@PathVariable("id")long idTessera){
       return tesseraService.getTessera(idTessera);
    }

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
