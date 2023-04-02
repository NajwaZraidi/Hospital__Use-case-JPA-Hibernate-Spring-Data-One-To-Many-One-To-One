package ma.enset.service;

import jakarta.transaction.Transactional;
import ma.enset.entities.Consultation;
import ma.enset.entities.Medecin;
import ma.enset.entities.Patient;
import ma.enset.entities.RendezVous;
import ma.enset.repositories.ConsultationRepository;
import ma.enset.repositories.MedecinRepository;
import ma.enset.repositories.PatientRepository;
import ma.enset.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    //Injection des depandances
    //@Autowired
    private PatientRepository patientRepository;
    //@Autowired
    private MedecinRepository medecinRepository;
    //@Autowired
    private RendezVousRepository rendezVousRepository;
    //@Autowired
    private ConsultationRepository consultationRepository;
    //Injection des depandances by constructor
    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        //Generation de id string
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
