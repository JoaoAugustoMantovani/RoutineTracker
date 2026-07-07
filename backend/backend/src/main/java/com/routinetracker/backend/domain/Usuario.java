package com.routinetracker.backend.domain;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

public class Usuario {

    @Id
    @UuidGenerator
    private UUID id;
    
    private String name;

    private String email;
}
