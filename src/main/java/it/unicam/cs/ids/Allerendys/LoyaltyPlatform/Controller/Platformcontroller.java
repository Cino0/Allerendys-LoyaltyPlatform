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
    public String registrazione(@RequestBody Cliente cliente){
        return loyaltyPlatform.registrazione(cliente);
    }

    @PostMapping("/add/{id}")
    public long registraCliente(@RequestBody Cliente cliente,@PathVariable("id") long idProgramma){
        return loyaltyPlatform.registraCliente(cliente,idProgramma);
    }
}
