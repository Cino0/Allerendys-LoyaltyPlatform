package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sms")
@Getter
@Setter
@NoArgsConstructor
public class Sms {
    @Transient
    public static final String SEQUENCE_NAME = "sms_sequence";

    @Id
    private long id;

    private String messaggio;

    private int finalita;


    public Sms(String messaggio){
        this.messaggio=messaggio;
    }
}
