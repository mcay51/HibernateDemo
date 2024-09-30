package tr.com.mcay.hibernateoptimization.job.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tr.com.mcay.hibernateoptimization.job.dto.JobDTO;
import tr.com.mcay.hibernateoptimization.job.model.Job;

@Mapper
public interface JobMapper {

    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    JobDTO jobToJobDTO(Job job);

    Job jobDTOToJob(JobDTO jobDTO);
}
