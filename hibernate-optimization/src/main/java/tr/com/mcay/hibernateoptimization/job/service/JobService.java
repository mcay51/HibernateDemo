package tr.com.mcay.hibernateoptimization.job.service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tr.com.mcay.hibernateoptimization.job.dto.JobDTO;
import tr.com.mcay.hibernateoptimization.job.model.Job;
import tr.com.mcay.hibernateoptimization.job.dto.mapper.JobMapper;
import tr.com.mcay.hibernateoptimization.job.repository.JobRepository;
import tr.com.mcay.hibernateoptimization.person.model.Person;

@Service
public class JobService {


    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Cacheable(value = "jobs", unless = "#result == null") // Job verisini cache'den alır, eğer yoksa veritabanından alır
    public JobDTO getJobById(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Job not found "+id));        return JobMapper.INSTANCE.jobToJobDTO(job);
    }

    @CacheEvict(value = "jobs", key = "#id") // Cache'deki Job verisini siler
    public void deleteJob(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Job not found "+id));
        jobRepository.delete(job);
    }

    @CachePut(value = "jobs", key = "#result.id") // Cache'i günceller ya da ekler
    public JobDTO saveOrUpdateJob(JobDTO jobDTO) {
        Job job = JobMapper.INSTANCE.jobDTOToJob(jobDTO);
        Job savedJob = jobRepository.save(job);
        return JobMapper.INSTANCE.jobToJobDTO(savedJob);
    }
}