package ma.enset.repositories;

import ma.enset.entities.Medecin;
import ma.enset.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
 Medecin findByNom(String nom);


}
