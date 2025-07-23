package com.vw.consent.management.system.user.infrastructure.repository.postgresql.entity;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;
    // Esto genera una tabla secundaria
    // Es una forma compacta y directa de representar los consentimientos sin tener que modelar una entidad separada.
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_consents", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "consent_type")
    @Column(name = "enabled")
    private Map<String, Boolean> consents = new HashMap<>();

    public UserEntity() {}

    public UserEntity(UUID id, String email, Map<String, Boolean> consents) {
        this.id = id;
        this.email = email;
        this.consents = consents;
    }

    // Getters y setters

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Boolean> getConsents() {
        return consents;
    }
}
