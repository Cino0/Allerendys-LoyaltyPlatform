package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Iscrizioni {

    private String programma;
    private  int punti;
    private int livello;
    private double cashback;


    public Iscrizioni(String programma,int cashback, int punti, int livello) {
        this.programma = programma;
        this.cashback=cashback;
        this.punti = punti;
        this.livello = livello;
    }
}
