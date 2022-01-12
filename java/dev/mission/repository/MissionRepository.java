package dev.mission.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mission.entite.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
	
	  List<Mission> findAllByDateDebutGreaterThanEqual(LocalDate dateDebut);
	  List<Mission> findAllByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual(LocalDate dateDebut, BigDecimal taux);
	
}