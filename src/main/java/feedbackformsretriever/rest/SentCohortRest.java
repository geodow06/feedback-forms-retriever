package feedbackformsretriever.rest;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
