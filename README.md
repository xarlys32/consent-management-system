#  Consent Management System
This system is build in based of 2 main domains, user and consent. Once a user change his consent
status, emit a domain event to Kafka for being read by the consent domain and create an history in mongo db 

## Hexagonal
User Management Domain

Responsabilidad: Manejar la creación, validación y unicidad de los usuarios.

    Entidad principal: User
    Valor clave: email (identificador único)
    Reglas de negocio:
        Email debe ser válido y único.
        Soporta operaciones CRUD sobre usuarios.
    Motivación DDD: Esta parte está centrada en la identidad del usuario. No tiene conocimiento de los consentimientos, pero es dueño de ellos.

🧩 2. Consent Management Domain

Responsabilidad: Gestionar los consentimientos del usuario y su historial.

    Entidad principal: ConsentChangeEvent
    Valor asociado: ConsentStatus (compuesto de email_notifications, sms_notifications)
    Reglas de negocio:
        Un evento pertenece a un único usuario.
        No se puede modificar ni borrar un evento.
        Se requiere un historial completo de cambios (event sourcing-like).
        CRUD parcial: solo Create y Read.
    Motivación DDD: Aquí se modela la lógica de negocio de cómo se transforma el historial de eventos en un estado actual. Se puede aplicar patrones como event sourcing, aunque sea simplificado.

🔍 ¿Por qué no es todo un solo dominio?

Porque tienen reglas distintas, objetivos distintos, y modelos de datos diferentes:

    El usuario tiene reglas como “email único y válido”.
    Los eventos tienen reglas como “solo se pueden crear, no editar ni borrar”.
    Además, se menciona que el estado de consentimiento se reconstruye aplicando los eventos en orden, lo cual es lógica específica del dominio de consentimientos.

## DB POSTGRESQL
https://hackernoon.com/using-postgres-effectively-in-spring-boot-applications
Para la Base de datos relacional habra dos entidades, USER y USER_CONSENT. Ya que solo hay una entrada por tipo de consentimiento, en java usaremos un map Map<ConsentType, Boolean> para 
ahorrarnos el desarrollo de la entidad consent.
CREATE TABLE users (
id UUID PRIMARY KEY,
email VARCHAR(255) NOT NULL UNIQUE
);
CREATE TABLE user_consents (
user_id UUID REFERENCES users(id) ON DELETE CASCADE,
consent_type VARCHAR(50) NOT NULL,
enabled BOOLEAN NOT NULL,
PRIMARY KEY (user_id, consent_type)
);

## CQRS
Los Command deben usar tipos primitivos o simples (String, UUID, boolean, etc.), no tipos del dominio como Email, ConsentStatus, etc.