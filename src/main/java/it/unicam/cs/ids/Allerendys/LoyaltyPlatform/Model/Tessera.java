package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document(collection = "Tessere")
@Setter
@Getter
public class Tessera {

    @Id
    private String idTessera;

    private List<Iscrizioni> iscrizioni;

    private List<Sconti> sconti;


    public Tessera(String idTessera) {
        this.idTessera = idTessera;
        this.iscrizioni = new ArrayList<>();
    }

    public void addIscricione(String idProgramma){
        Iscrizioni newIscr= new Iscrizioni(idProgramma,0,0,"base");
        this.iscrizioni.add(newIscr);



    }

    public void addScontoPersonale(Sconti sconti) {
        this.sconti.add(sconti);
    }
}
