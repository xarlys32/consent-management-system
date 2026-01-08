
\connect consent_management;

CREATE TABLE  IF NOT EXISTS users (
id UUID PRIMARY KEY,
email VARCHAR(255) NOT NULL UNIQUE,
created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);
CREATE TABLE  IF NOT EXISTS user_consents (
user_id UUID REFERENCES users(id) ON DELETE CASCADE,
consent_type VARCHAR(50) NOT NULL,
enabled BOOLEAN NOT NULL,
PRIMARY KEY (user_id, consent_type)
);