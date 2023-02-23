package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Locali")
@Getter
@Setter
public class Locale {



    @Transient
    public static final String SEQUENCE_NAME = "locale_sequence";

    @Id
    private long idLocale;

    private String nome;

    private String proprietario;

    private String citta;

    private String indirizzo;

    private List<Programma> programmiFedelta;

    private List<Recensione> recensioni;

    private List<Sms> campagneSms;


    public Locale(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
        this.programmiFedelta = new ArrayList<>();
        this.recensioni = new ArrayList<>();
        this.campagneSms = new ArrayList<>();
    }

    public void addRecensione(Recensione recensione)
    {
        this.recensioni.add(recensione);
    }

    public void addSms(Sms sms){
        this.campagneSms.add(sms);
    }



    public void addProgramma(Programma programma){
        this.programmiFedelta.add(programma);
    }

    public int getNumProgrammi(){
        return programmiFedelta.size();
    }

}
