package com.vw.consent.management.system.user.infrastructure.repository.postgresql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_consents", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "consent_type")
    @Column(name = "enabled")
    private Map<String, Boolean> consent;
    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ")
    private Instant createdAt;

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
