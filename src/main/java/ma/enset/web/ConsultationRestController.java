package ma.enset.web;

import ma.enset.entities.Consultation;
import ma.enset.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultationRestController {
    @Autowired
        private ConsultationRepository consultationRepository;
    @GetMapping("/Consultations")
    public List<Consultation> Consultations() {
        return consultationRepository.findAll();

    }



}
