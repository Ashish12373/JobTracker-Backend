package com.example.JobTracker.jobs;

import com.example.JobTracker.contact.ContactDTO;

import java.util.List;

public class JobMapper {
    public static JobDTO toDto(Job job) {
        return JobDTO.builder()
                .id(job.getId())
                .company(job.getCompany())
                .role(job.getRole())
                .status(job.getStatus())
                .appliedOn(job.getAppliedOn())
                .location(job.getLocation())
                .platform(job.getPlatform())
                .resume(job.getResume())
                .followUp(job.getFollowUp())
                .interviewDate(job.getInterviewDate())
                .jobLink(job.getJobLink())
                .feedback(job.getFeedback())
                .contacts(
                        job.getContacts() != null
                                ? job.getContacts().stream()
                                .map(c -> new ContactDTO(c.getId(), c.getName(), c.getRole(), c.getEmail()))
                                .toList()
                                : List.of()
                )
                .build();
    }
}
