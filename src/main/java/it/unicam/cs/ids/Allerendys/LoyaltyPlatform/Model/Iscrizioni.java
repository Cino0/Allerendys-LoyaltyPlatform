package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;


import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
@Getter
public class Iscrizioni {



    @Transient
    public static final String SEQUENCE_NAME = "iscrizioni_sequence";


    @Id
    private String id;
    private String programma;
    private  int punti;
    private String livello;
    private double cashback;


    public Iscrizioni(String programma,int cashback, int punti, String livello) {
        this.programma = programma;
        this.cashback=cashback;
        this.punti = punti;
        this.livello = livello;
    }



    public String visualizzaStatus(){
        String status = ""+this.programma.toString()+
                ""+this.punti+
                ""+this.livello+
                ""+this.cashback;
        return status;
    }
}
