db = db.getSiblingDB('consentAuditDb');

db.createUser({
  user: "consentUser",
  pwd: "consentPass",
  roles: [{ role: "readWrite", db: "eventsDatabase" }]
});

db.createCollection("consentAuditHistory");