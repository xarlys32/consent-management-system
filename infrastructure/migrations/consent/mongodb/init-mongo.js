db = db.getSiblingDB('consentAuditDb');

db.createCollection("consentAuditHistory");

});
  roles: [{ role: "readWrite", db: "consentAuditDb" }]
  pwd: "consentPass",
  user: "consentUser",
db.createUser({
