package feedbackformsretriever.rest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Optional<SentCohort> findCohortByID(@PathVariable Long id) {
		return repo.findByCohortId(id);
	}

	@GetMapping("${path.getCohorts}")
	public Collection<SentCohort> getAllCohorts() {
		return repo.findAll();
	}

//	@PutMapping("${path.updateWeek}")
//	public void weekUpdate(SentCohort sentCohort) throws ParseException {
//
//		String pattern = "yyyy-MM-dd";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		
//		String currentDate_String = new Timestamp(System.currentTimeMillis()).toString().substring(0, 10);
//		Date currentDate = simpleDateFormat.parse(currentDate_String);
//		
//		Date dateCreated = simpleDateFormat.parse(sentCohort.getWeek());
//	}
//
//	private long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
//		long diffInMillies = date2.getTime() - date1.getTime();
//		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
//	}

}
