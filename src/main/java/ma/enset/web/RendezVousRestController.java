package ma.enset.web;

import ma.enset.entities.RendezVous;
import ma.enset.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RendezVousRestController {
    @Autowired
        private RendezVousRepository rendezVousRepository;
    @GetMapping("/rendez-Vous")
    public List<RendezVous> RendezVous() {
        return rendezVousRepository.findAll();

    }



}
