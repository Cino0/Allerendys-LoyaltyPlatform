package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Controller;


import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Cliente;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @RequestMapping("/save")
    public String salvaCliente(@RequestBody Cliente cliente){
        return clienteService.salvaCliente(cliente);
    }


    @RequestMapping("/check")
    public Optional<Cliente> controllaDati(Cliente cliente){
        return clienteService.controllaDati(cliente);
    }

}
