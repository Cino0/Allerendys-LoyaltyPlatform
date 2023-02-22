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


    public Coalizione(long id,String nome,Programma programma, List<Long> locali)
    {
        this.id=id;
        this.nome=nome;
        this.programma=programma;
        this.locali=locali;
    }
    public void addLocale(long idLocale){
        this.locali.add(idLocale);
    }

}
