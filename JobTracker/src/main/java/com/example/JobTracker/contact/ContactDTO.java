package com.example.JobTracker.contact;



// Using Java 16+ record (immutable, clean)
public record ContactDTO(
        Long id,
        String name,
        String role,
        String email
) { }
