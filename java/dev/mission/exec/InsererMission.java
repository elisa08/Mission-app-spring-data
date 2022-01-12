package dev.mission.exec;

import java.math.BigDecimal;
import java.time.LocalDate;


import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

@Controller
@Profile("insert")
public class InsererMission implements CommandLineRunner {

	private MissionRepository missionRepository;

	public InsererMission(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
    public void run(String... args) throws Exception {
		Mission mission = new Mission();
		mission.setLibelle("Mission 1");
		mission.setTauxJournalier(new BigDecimal("100.90"));
		mission.setDateDebut(LocalDate.now());
		mission.setDateFin(LocalDate.of(2023, 3, 4));

		this.missionRepository.save(mission);
		
		System.out.println("insertion d'une mission");
	}
}