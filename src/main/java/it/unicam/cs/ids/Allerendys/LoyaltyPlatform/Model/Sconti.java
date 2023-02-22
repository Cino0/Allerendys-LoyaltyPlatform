package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
public class Sconti
{

    @Transient
    public static final String SEQUENCE_NAME = "sconti_sequence";

    @Id
    private String idSconto;
    private String nome;
    private double sconto;

    private int finalita;

    public Sconti(String nome,double sconto){
        this.nome=nome;
        this.sconto=sconto;
    }


    public Sconti(String idSconto)
    {
        this.idSconto=idSconto;
    }
}
