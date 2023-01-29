package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;


import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Cliente;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Iscrizioni;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Tessera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.util.Optional;

@Service
public class LoyaltyPlatform {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private TesseraService tesseraService;

    public String registrazione(Cliente cliente){
        Optional<Cliente> c = clienteService.controllaDati(cliente);
        if(c.isPresent()){
            return "Dati gia presenti,per favore reinserire";
        }else {
            Tessera t = new Tessera("Id");
            cliente.setIdTessera(t.getIdTessera());
            clienteService.salvaCliente(cliente);
            tesseraService.salvaTessera(t);
        }
        return cliente.getCodiceFiscale();
    }

    public String registraCliente(Cliente cliente ,String idProgramma){
        Optional<Cliente> c = clienteService.controllaDati(cliente);
        if(c.isPresent()){
            return "Dati gia presenti,per favore reinserire";
        }else {
            Tessera t = new Tessera("idTessera");
            cliente.setIdTessera(t.getIdTessera());
            clienteService.salvaCliente(cliente);
            t.addIscricione(idProgramma);
            System.out.println(t.toString());
            return tesseraService.salvaTessera(t);
        }
    }
}
