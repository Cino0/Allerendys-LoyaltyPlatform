package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import ch.qos.logback.core.testUtil.TeeOutputStream;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document(collection = "Tessere")
@Setter
@Getter
public class Tessera {



    @Transient
    public static final String SEQUENCE_NAME = "tessera_sequence";


    @Id
    private long idTessera;

    private List<Iscrizioni> iscrizioni;

    private List<Sconti> sconti;

    public Tessera(){
        this.iscrizioni= new ArrayList<>(1000);
        this.sconti = new ArrayList<>(1000);
    }

    public Iscrizioni addIscricione(long idProgramma){
        Iscrizioni newIscr= new Iscrizioni(idProgramma,0,0,"base",this.idTessera);
        this.iscrizioni.add(newIscr);
        return newIscr;
    }

    public void addScontoPersonale(Sconti sconti) {
        this.sconti.add(sconti);
    }
}
