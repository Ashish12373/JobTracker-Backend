// src/main/java/com/example/JobTracker/jobs/Job.java
package com.example.JobTracker.jobs;

import com.example.JobTracker.auth.User;
import com.example.JobTracker.contact.Contact;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

    private String company;
    private String role;
    private String status;
    private String appliedOn;
    private String location;
    private String platform;
    private String resume;
    private String followUp;
    private String interviewDate;
    private String jobLink;
    private String feedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
