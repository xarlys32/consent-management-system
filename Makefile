start:
	docker-compose up -d
	./gradlew bootRun

stop:
	docker-compose down
	./gradlew bootRun