package ma.enset.repositories;

import ma.enset.entities.Consultation;
import ma.enset.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
