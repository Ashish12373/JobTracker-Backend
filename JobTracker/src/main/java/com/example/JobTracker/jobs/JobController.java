package com.example.JobTracker.jobs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/{username}")
    public List<JobDTO> getJobs(@PathVariable String username) {
        return jobService.getJobsForUser(username);
    }

    @PostMapping("/{username}")
    public JobDTO createJob(@PathVariable String username, @RequestBody JobDTO dto) {
        return jobService.createJob(username, dto);
    }

    @PutMapping("/{jobId}")
    public JobDTO updateJob(@PathVariable Long jobId, @RequestBody JobDTO dto) {
        return jobService.updateJob(jobId, dto);
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long jobId) {
        jobService.deleteJob(jobId);
        return ResponseEntity.noContent().build();
    }
}
