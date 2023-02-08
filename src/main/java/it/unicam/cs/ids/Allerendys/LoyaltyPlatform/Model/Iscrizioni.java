package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Iscrizioni {

    private String programma;
    private  int punti;
    private int livello;


    public Iscrizioni(String programma, int punti, int livello) {
        this.programma = programma;
        this.punti = punti;
        this.livello = livello;
    }
}
