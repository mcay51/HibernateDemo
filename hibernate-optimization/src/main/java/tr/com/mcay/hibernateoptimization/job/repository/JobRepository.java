package tr.com.mcay.hibernateoptimization.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.hibernateoptimization.job.model.Job;

public interface JobRepository extends JpaRepository<Job,Long> {
}
