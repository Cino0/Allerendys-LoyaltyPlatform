package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Getter
@Setter
@Data

public class Coalizione {


    @Transient
    public static final String SEQUENCE_NAME = "coalizione_sequence";


    @Id
    private long id;

    private String nome;

    private Programma programma;

    private List<Long> locali;


    public Coalizione(String nome,Programma programma)
    {
        this.nome=nome;
        this.programma=programma;
    }
    public void addLocale(long idLocale){
        this.locali.add(idLocale);
    }

}
