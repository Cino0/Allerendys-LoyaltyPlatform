package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Dipendeti")

@Getter
@Setter
public class Dipendente {


    @Transient
    public static final String SEQUENCE_NAME = "cubo_sequence";

    private String idDipendente;

    private String nome;

    private String cognome;

    private String localeImpiego;


    public Dipendente(String idDipendente, String nome, String cognome) {
        this.idDipendente = idDipendente;
        this.nome = nome;
        this.cognome = cognome;
    }
}
