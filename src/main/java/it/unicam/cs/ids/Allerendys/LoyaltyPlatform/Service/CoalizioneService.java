package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Coalizione;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.CoalizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoalizioneService {

    @Autowired
    private CoalizioneRepository coalizioneRepository;

    public Optional<Coalizione> getCoalizione(long idCoalizione)
    {
        return coalizioneRepository.findById(idCoalizione);
    }
    public long salvaCoalizione(Coalizione coalizione){
        return coalizioneRepository.save(coalizione).getId();
    }
}
