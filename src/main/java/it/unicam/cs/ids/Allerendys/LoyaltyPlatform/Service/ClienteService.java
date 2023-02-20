package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;


import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Cliente;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Service

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public String salvaCliente(Cliente cliente){
      return clienteRepository.save(cliente).getCodiceFiscale();
   }

    public Optional<Cliente> controllaDati(Cliente cliente){
        return clienteRepository.findById(cliente.getCodiceFiscale());
    }


    public Optional<Cliente> autenticazione(String codicefiscale)
    {
        return clienteRepository.findById(codicefiscale);
    }
}
