package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Controller;


import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Cliente;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service.LoyaltyPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/platform")
public class Platformcontroller {

    @Autowired
    private LoyaltyPlatform loyaltyPlatform;

    @PostMapping("/singin")
    public String registrazione(){
        return loyaltyPlatform.registrazione();
    }

    @PostMapping("/add/{id}")
    public String registraCliente(@RequestBody Cliente cliente,@PathVariable("id") String idProgramma){
        return loyaltyPlatform.registraCliente(cliente,idProgramma);
    }
}
