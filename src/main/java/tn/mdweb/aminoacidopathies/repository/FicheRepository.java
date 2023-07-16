package tn.mdweb.aminoacidopathies.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import tn.mdweb.aminoacidopathies.domain.Fiche;

/**
 * Spring Data JPA repository for the Fiche entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FicheRepository extends JpaRepository<Fiche, Long> {}
