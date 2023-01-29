package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Controller;


import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service.LoyaltyPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
public class Platformcontroller {

    @Autowired
    private LoyaltyPlatform loyaltyPlatform;

    @PostMapping("/singin")
    public String registrazione(){
        return loyaltyPlatform.registrazione();
    }

    @PostMapping("/addCliente")
    public String registraCliente(){
        return loyaltyPlatform.registraCliente();
    }
}
