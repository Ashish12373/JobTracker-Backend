package com.example.JobTracker.contact;

import com.example.JobTracker.jobs.Job;
import com.example.JobTracker.jobs.JobRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepo;
    private final JobRepository jobRepo;

    @Transactional
    public ContactDTO addContact(Long jobId, ContactDTO dto) {
        Job job = jobRepo.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Contact contact = Contact.builder()
                .name(dto.name())
                .role(dto.role())
                .email(dto.email())
                .job(job)
                .build();

        contactRepo.save(contact);
        return new ContactDTO(contact.getId(), contact.getName(), contact.getRole(), contact.getEmail());
    }

    @Transactional
    public ContactDTO updateContact(Long contactId, ContactDTO dto) {
        Contact contact = contactRepo.findById(contactId)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        contact.setName(dto.name());
        contact.setRole(dto.role());
        contact.setEmail(dto.email());

        return new ContactDTO(contact.getId(), contact.getName(), contact.getRole(), contact.getEmail());
    }

    @Transactional
    public void deleteContact(Long contactId) {
        if (!contactRepo.existsById(contactId)) {
            throw new RuntimeException("Contact not found");
        }
        contactRepo.deleteById(contactId);
    }
}
