package ma.enset;

import ma.enset.entities.*;
import ma.enset.repositories.ConsultationRepository;
import ma.enset.repositories.MedecinRepository;
import ma.enset.repositories.PatientRepository;
import ma.enset.repositories.RendezVousRepository;
import ma.enset.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    //test
    CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository){
    //CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){
        return args -> {
            Stream.of("Khalid","Islam","Awjan")
                    .forEach(
                            name->{
                                Patient patient=new Patient();
                                patient.setNom(name);
                                patient.setDateNaissance(new Date());
                                patient.setMalade(false);
                                //patientRepository.save(patient);
                                hospitalService.savePatient(patient);
                            }
                    );
            Stream.of("Aymane","Yassmin","Yasin")
                    .forEach(
                            name->{
                                Medecin medecin=new Medecin();
                                medecin.setNom(name);
                                medecin.setEmail(name+"@gmail.com");
                                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                                //medecinRepository.save(medecin);
                                hospitalService.saveMedecin(medecin);
                            }
                    );
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Awjan");

            Medecin medecin=medecinRepository.findByNom("Aymane");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.EN_COURS);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            //rendezVousRepository.save(rendezVous);
            hospitalService.saveRDV(rendezVous);


           // RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de a consultation .....");
            //consultationRepository.save(consultation);
            hospitalService.saveConsultation(consultation);
        };
    }
}
