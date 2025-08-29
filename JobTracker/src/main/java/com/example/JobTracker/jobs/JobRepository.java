package com.example.JobTracker.jobs;

import com.example.JobTracker.auth.User;
import com.example.JobTracker.jobs.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByUser(User user);
}
