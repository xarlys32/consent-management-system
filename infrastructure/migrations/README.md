This folder contains DB initialization scripts mounted by docker-compose.

- postgres/init-postgres.sql: SQL script used by the Postgres container at startup (mounted to /docker-entrypoint-initdb.d).
- mongodb/init-mongo.js: JS script used by the MongoDB container at startup (mounted to /docker-entrypoint-initdb.d).

NOTE: These scripts were originally located under `src/main/java/.../common/infrastructure/migrations`. They were moved to the repository root `infrastructure/migrations` so docker-compose can mount them directly.

If you prefer migraciones versionadas with Flyway, move/duplicate SQL scripts to `src/main/resources/db/migration` and enable Flyway in application.properties.

