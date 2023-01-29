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

    @RequestMapping ("/adesione")
    public String adesioneProgramma(String idTessera){
        return tesseraService.adesioneProgramma(idTessera);
    }

    @RequestMapping("/sconti/{id}")
    public String visualizzaSconti(@PathVariable("id")String idTessera){
        return tesseraService.VisualizzaSconti(idTessera);
    }

}
