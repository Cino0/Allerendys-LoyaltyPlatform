package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@Data

public class Coalizione {

    @Id
    private String id;

    private String nome;

    private Programma programma;

    private List<Locale> locali;


    public void addLocale(){
        //TODO
    }

    //TODO costruttore
}
