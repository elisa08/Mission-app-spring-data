package dev.mission.exec;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;
@Controller
@Profile("lister")
public class ListerMission implements CommandLineRunner{
	
	private MissionRepository missionRepo;
	
	public ListerMission(MissionRepository missionRepo) {
		super();
		this.missionRepo = missionRepo;
		
	}
	
	@Override
    public void run(String... args) throws Exception {

		List<Mission> prochaineMission= missionRepo.findAllByDateDebutGreaterThanEqual(LocalDate.now());
		
		for (Mission mission : prochaineMission) {
			
			System.out.println(mission);
			
		}
		
		List<Mission> prochaineMissionTaux= missionRepo.findAllByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual(LocalDate.now(), new BigDecimal("250.00"));
		
		for (Mission mission2 : prochaineMissionTaux) {
			
			
			System.out.println("-------------" + mission2);
			
		}
	}	

}
