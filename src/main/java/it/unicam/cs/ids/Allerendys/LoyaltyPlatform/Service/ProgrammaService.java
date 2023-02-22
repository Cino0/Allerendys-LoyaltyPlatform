package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Programma;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Sconti;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.ProgrammaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammaService {

    @Autowired
    private ProgrammaRepository programmaRepository;


    public long salva(Programma programma){
        return programmaRepository.save(programma).getIdProgramma();
    }


    public List<Programma> getProgrammi(){
        return programmaRepository.findAll();
    }

    public Optional<Programma> getPrograma(long idProgramma){
        return programmaRepository.findById(idProgramma);
    }


    public void aggiungiScontoaProgramma(Sconti sconto,long idProgramma){
        Optional<Programma> p =programmaRepository.findById(idProgramma);
        if (p.isPresent()){

        }
    }
}
