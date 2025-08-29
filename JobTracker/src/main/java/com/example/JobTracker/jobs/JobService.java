package com.example.JobTracker.jobs;

import com.example.JobTracker.auth.User;
import com.example.JobTracker.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepo;
    private final UserRepository userRepo;

    @Transactional(readOnly = true)
    public List<JobDTO> getJobsForUser(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return jobRepo.findByUser(user).stream()
                .map(JobMapper::toDto)
                .toList();
    }

    @Transactional
    public JobDTO createJob(String username, JobDTO dto) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = Job.builder()
                .company(dto.getCompany())
                .role(dto.getRole())
                .status(dto.getStatus())
                .appliedOn(dto.getAppliedOn())
                .location(dto.getLocation())
                .platform(dto.getPlatform())
                .resume(dto.getResume())
                .followUp(dto.getFollowUp())
                .interviewDate(dto.getInterviewDate())
                .jobLink(dto.getJobLink())
                .feedback(dto.getFeedback())
                .user(user)
                .build();

        jobRepo.save(job);
        return JobMapper.toDto(job);
    }

    @Transactional
    public JobDTO updateJob(Long jobId, JobDTO dto) {
        Job job = jobRepo.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setCompany(dto.getCompany());
        job.setRole(dto.getRole());
        job.setStatus(dto.getStatus());
        job.setAppliedOn(dto.getAppliedOn());
        job.setLocation(dto.getLocation());
        job.setPlatform(dto.getPlatform());
        job.setResume(dto.getResume());
        job.setFollowUp(dto.getFollowUp());
        job.setInterviewDate(dto.getInterviewDate());
        job.setJobLink(dto.getJobLink());
        job.setFeedback(dto.getFeedback());

        return JobMapper.toDto(job);
    }

    @Transactional
    public void deleteJob(Long jobId) {
        if (!jobRepo.existsById(jobId)) {
            throw new RuntimeException("Job not found");
        }
        jobRepo.deleteById(jobId);
    }
}

