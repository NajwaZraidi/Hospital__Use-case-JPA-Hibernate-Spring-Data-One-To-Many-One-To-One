package ma.enset.web;

import ma.enset.entities.Medecin;
import ma.enset.repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedecinRestController {
    @Autowired
        private MedecinRepository medecinRepository;
    @GetMapping("/medecins")
    public List<Medecin> medecins() {
        return medecinRepository.findAll();

    }



}
