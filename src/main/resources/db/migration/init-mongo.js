// MongoDB initialization for local/dev when using Docker

db = db.getSiblingDB('consentAuditDb');

db.createUser({
  user: "consentUser",
  pwd: "consentPass",
  roles: [{ role: "readWrite", db: "consentAuditDb" }]
});

db.createCollection("consentAuditHistory");
