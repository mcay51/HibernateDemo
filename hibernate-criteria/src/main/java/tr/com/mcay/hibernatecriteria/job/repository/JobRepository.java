package tr.com.mcay.hibernatecriteria.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.hibernatecriteria.job.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}