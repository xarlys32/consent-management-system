package com.vw.consent.management.system.user.infrastructure.repository.postgresql.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;
    // Esto genera una tabla secundaria
    // Es una forma compacta y directa de representar los consentimientos sin tener que modelar una entidad separada.
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_consents", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "consent_type")
    @Column(name = "enabled")
    private Map<String, Boolean> consent = new HashMap<>();
    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ")
    private Instant createdAt;

    public UserEntity() {}

    public UserEntity(UUID id, String email, Map<String, Boolean> consent, Instant createdAt) {
        this.id = id;
        this.email = email;
        this.consent = consent;
        this.createdAt = createdAt;
    }

    // Getters y setters

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Boolean> getConsent() {
        return consent;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConsent(Map<String, Boolean> consent) {
        this.consent = consent;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
