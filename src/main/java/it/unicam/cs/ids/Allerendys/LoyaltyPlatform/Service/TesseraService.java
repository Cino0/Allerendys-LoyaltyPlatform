package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.*;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.ProgrammaRepository;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.ScontiRepository;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository.TesseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TesseraService {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private TesseraRepository tesseraRepository;

    @Autowired
    private ProgrammaService programmaService;


    @Autowired
    private ScontiService scontiService;

    public String adesioneProgramma(long idTessera, long idProgramma) {
        Optional<Tessera> t = tesseraRepository.findById(idTessera);
        if (t.isPresent()) {
            t.get().addIscricione(idProgramma);
            tesseraRepository.deleteById(idTessera);
            this.salvaTessera(t.get());
        }
        return null;
    }

    public String VisualizzaSconti(long idTessera) {
        Optional<Tessera> t = tesseraRepository.findById(idTessera);
        List<Iscrizioni> iscr = t.get().getIscrizioni();
        StringBuilder totSconti = new StringBuilder();
        for (int x = 0; x < iscr.size(); x++) {
            long p = iscr.get(x).getProgramma();
            Optional<Programma> prog = programmaService.getPrograma(p);

            if (prog.isPresent()) {
                List<Sconti> sconti = prog.get().getSconti();
                totSconti.append(sconti.stream().findAny().get().toString());

            }
        }
        return totSconti.toString();
    }

    public String VisualizzaPunti(long idTessera) {
        Optional<Tessera> t = tesseraRepository.findById(idTessera);
        List<Iscrizioni> iscr = t.get().getIscrizioni();
        StringBuilder totPunti = new StringBuilder();
        for (int i = 0; i < iscr.size(); i++) {
            long p = iscr.get(i).getProgramma();
            Optional<Programma> prog = programmaService.getPrograma(p);
            if (prog.isPresent()) {
                totPunti.append(iscr.stream().findAny().get().toString());
            }
        }
        return totPunti.toString();

    }

    public String VisualizzaCashback(long idTessera)
    {
        Optional<Tessera> t=tesseraRepository.findById(idTessera);
        List<Iscrizioni> iscr=t.get().getIscrizioni();
        StringBuilder cashback= new StringBuilder();
        for(int i=0;i<iscr.size();i++) {
            long p=iscr.get(i).getProgramma();
            Optional<Programma> prog=programmaService.getPrograma(p);
            if(prog.isPresent())
            {
                cashback.append((iscr.stream().findAny().toString()));
            }
        }
        return cashback.toString();
    }

    public String VisualizzaLivello(long idTessera) {
        Optional<Tessera> t = tesseraRepository.findById(idTessera);
        List<Iscrizioni> iscr = t.get().getIscrizioni();
        StringBuilder livello = new StringBuilder();
        for (int i = 0; i < iscr.size(); i++) {
            long p = iscr.get(i).getProgramma();
            Optional<Programma> prog = programmaService.getPrograma(p);
            if (prog.isPresent()) {
                livello.append(iscr.stream().findAny().toString());
            }
        }
        return livello.toString();
    }

    public long salvaTessera(Tessera tessera) {
        return tesseraRepository.save(tessera).getIdTessera();
    }

    public String aggiuntaSconto(long idTessera, long idSconto) {
        Query query = new Query();
        Criteria crit = new Criteria("_id").is(idTessera);
        Update update = new Update();
        query.addCriteria(crit);
        Optional<Tessera> t = tesseraRepository.findById(idTessera);
        Optional<Sconti> sconti = scontiService.controllaSconto(idSconto);
        if (sconti.isPresent()) {
            t.get().addScontoPersonale(sconti.get());
            List<Sconti> sc = t.get().getSconti();
            update.set("sconti",sc);
            mongoTemplate.updateFirst(query,update,Tessera.class);
        }
        return null;
    }

    public Optional<Tessera> controlloTessera(long idTessera) {
        Optional<Tessera> t =this.tesseraRepository.findById(idTessera);
        return t;
    }


    public Iscrizioni getIscrizione(long idProgramma,long idTessera){
        Optional<Tessera> t =this.tesseraRepository.findById(idTessera);
        if(t.isPresent()){
            for(Iscrizioni i :t.get().getIscrizioni()){
                if (i.getProgramma()==idProgramma){
                    return i;
                }
            }
        }
        return null;
    }
}