package feedbackformsretriever.rest;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import feedbackformsretriever.persistence.domain.SentCohort;
import feedbackformsretriever.persistence.repository.MongoCohortRepo;

@CrossOrigin
@RequestMapping("${path.cohorts}")
@RestController
public class SentCohortRest {

	@Autowired
	private MongoCohortRepo repo;

	@GetMapping("${path.getCohortbyID}")
	public SentCohort findCohortByID(@PathVariable Long id) {
		return repo.findByCohortID(id);
	}

	@GetMapping("${path.getCohorts}")
	public Collection<SentCohort> getAllCohorts() {
		return repo.findAll();
	}

	@DeleteMapping("${path.deleteByCohortName}")
	public Long deleteByCohortName(@PathVariable String cohortName) {
		return repo.deleteByCohortName(cohortName);
	}

	@Value("${datePattern}")
	private String pattern;

	@Value("${1Week}")
	private int week;

	@PutMapping("${path.updateWeekNumber}")
	public Long weekUpdate(@PathVariable Long cohortID) throws ParseException {
		SentCohort sentCohort = repo.findByCohortID(cohortID);

		String currentDate = getCurrentDate();
		String dateCreated = sentCohort.getCreatedOn();

		long diff = getDateDiff(dateCreated, currentDate);

		return weekIncrement(sentCohort, (int) diff, cohortID);
	}

	private long getDateDiff(String dateCreated, String currentDate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate datel = LocalDate.parse(currentDate, formatter);
		LocalDate date2 = LocalDate.parse(dateCreated, formatter);
		long daysBetween = ChronoUnit.DAYS.between(datel, date2);
		if (daysBetween > 0) {
			return daysBetween;
		} else {
			return (daysBetween * -1);
		}
	}

	private String getCurrentDate() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}

	private long weekIncrement(SentCohort sentCohort, int diff, Long cohortID) {
		sentCohort.setWeek(diff / week + 1);
		repo.deleteByCohortID(cohortID);

		repo.save(sentCohort);
		return (long) sentCohort.getWeek();
	}

}
