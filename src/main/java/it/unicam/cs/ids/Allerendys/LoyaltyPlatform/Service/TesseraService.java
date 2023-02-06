package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.*;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.TesseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TesseraService {

    @Autowired
    private TesseraRepository tesseraRepository;

    private ProgrammaService programmaService;

    public String adesioneProgramma(String idTessera, String idProgramma)
    {
        Optional<Tessera> t = tesseraRepository.findById(idTessera);
        if(t.isPresent()){
            t.get().addIscricione(idProgramma);
            tesseraRepository.deleteById(idTessera);
            this.salvaTessera(t.get());
        }
        return null;
    }

    public String VisualizzaSconti(String idTessera){
        Optional<Tessera> t = tesseraRepository.findById(idTessera);
        List<Iscrizioni> iscr = t.get().getIscrizioni();
        StringBuilder totSconti= new StringBuilder();
        for (int x=0;x<iscr.size();x++){
            String p = iscr.get(x).getProgramma();
            Optional<Programma> prog = programmaService.getPrograma(p);
            if(prog.isPresent()){
                List<Sconti> sconti = prog.get().getSconti();
                totSconti.append(sconti.stream().findAny().get().toString());

            }
        }
        return totSconti.toString();
    }

    public String salvaTessera(Tessera tessera){
        return tesseraRepository.save(tessera).getIdTessera();
    }
}
