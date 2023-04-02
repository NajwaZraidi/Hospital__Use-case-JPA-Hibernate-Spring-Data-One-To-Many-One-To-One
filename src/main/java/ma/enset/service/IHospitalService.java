package ma.enset.service;

import ma.enset.entities.Consultation;
import ma.enset.entities.Medecin;
import ma.enset.entities.Patient;
import ma.enset.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
