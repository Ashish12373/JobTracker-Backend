package com.example.JobTracker.contact;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/{jobId}/contacts")
    public ContactDTO addContact(@PathVariable Long jobId, @RequestBody ContactDTO dto) {
        return contactService.addContact(jobId, dto);
    }

    @PutMapping("/contacts/{contactId}")
    public ContactDTO updateContact(@PathVariable Long contactId, @RequestBody ContactDTO dto) {
        return contactService.updateContact(contactId, dto);
    }

    @DeleteMapping("/contacts/{contactId}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long contactId) {
        contactService.deleteContact(contactId);
        return ResponseEntity.noContent().build();
    }
}
