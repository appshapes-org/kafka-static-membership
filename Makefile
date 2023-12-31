build:
	$(CURDIR)/gradlew build

clean:
	$(CURDIR)/gradlew clean
	git clean -xdf .ignored

commit-only: build test
	git add --verbose :/ .
	git commit -m "$(message)"

commit: commit-only
	git pull
	git push --verbose

down:
	docker compose down

gradle-tasks:
	$(CURDIR)/gradlew tasks --all

image:
	docker build --build-arg PROJECT=$(service) -f $(service)/Dockerfile -t $(service) .

image-run:
	docker run --name $(service) -it --rm --entrypoint $(command) $(service)

image-sh:
	docker exec -it $(service) sh

kafka-create-topic:
	docker exec kafka-static-membership-kafka-1 /opt/kafka/bin/kafka-topics.sh --bootstrap-server kafka-1:9091 --create --replication-factor 1 --partitions $(partitions) --topic $(topic)

kafka-describe-topic:
	docker exec kafka-static-membership-kafka-1 /opt/kafka/bin/kafka-topics.sh --describe --bootstrap-server kafka-1:9091 --topic $(topic)

kafka-list-topics:
	docker exec kafka-static-membership-kafka-1 /opt/kafka/bin/kafka-topics.sh --bootstrap-server kafka-1:9091 --list

kafka-list-offsets:
	docker exec kafka-static-membership-kafka-1 /opt/kafka/bin/kafka-consumer-groups.sh --bootstrap-server kafka-1:9091 --group $(group) --describe

kafka-reset-offsets:
	docker exec kafka-static-membership-kafka-1 /opt/kafka/bin/kafka-consumer-groups.sh --bootstrap-server kafka-1:9091 --group $(group) --reset-offsets --to-earliest --all-topics --execute

kafka-delete-topic:
	docker exec kafka-static-membership-kafka-1 /opt/kafka/bin/kafka-topics.sh --bootstrap-server kafka-1:9091 --delete --topic $(topic)

kube-apply:
	kubectl apply -f $(file)
	kubectl get pods

kube-delete:
	kubectl delete -f $(file)

stop:
	docker compose stop $(service)

test:
	$(CURDIR)/gradlew test

up:
	docker compose build $(service)
	docker compose up -d $(service)