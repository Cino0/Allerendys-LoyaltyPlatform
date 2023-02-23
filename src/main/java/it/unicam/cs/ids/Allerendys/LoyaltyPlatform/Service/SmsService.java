package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.DbIndex.SequenceGeneratorService;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Sms;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Autowired
     private SmsRepository smsRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;



    public void salvaMessaggio(Sms sms,int finalita){
        sms.setId(sequenceGeneratorService.generateSequence(Sms.SEQUENCE_NAME));
        sms.setFinalita(finalita);
        smsRepository.save(sms);
    }
}
