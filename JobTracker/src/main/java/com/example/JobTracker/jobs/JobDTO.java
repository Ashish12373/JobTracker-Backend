package com.example.JobTracker.jobs;

import com.example.JobTracker.contact.ContactDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data                       // generates getters, setters, equals, hashCode, toString
@NoArgsConstructor          // no-args constructor (needed for Jackson)
@AllArgsConstructor         // all-args constructor
@Builder                    // builder pattern
public class JobDTO {
    private Long id;
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

    private List<ContactDTO> contacts; // ✅ include hiring team
}
