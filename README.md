# What is this for?

This repository demonstrates Kafka consumer group static membership and using a Kubernetes stateful set to achieve that.

The main advantage of static membership is to limit rebalancing, and generally make that process more predictable. For a
set of applications the minimization of rebalancing is a critical requirement of the system.

# Who is this for?

Developers, platform engineers, and others may use this repository for design and architectural patterns for
implementing Kafka consumer group static membership.

# What is here?

## Producer

The `producer` retrieves a weather report for a random geo coordinate, and then publishes that weather report to a Kafka
topic.

The `producer` module is a Spring Boot non-web application with a Scheduled service that retrieves and then publishes a
weather report.

## Consumer

The `consumer` receives weather reports from a Kafka topic, and then logs them.

The `consumer` module is a Spring Boot non-web application with a KafkaListener service that receives and then logs
weather reports.

## Docker Compose

`docker-compose.yml` contains a 3-broker Kafka cluster definition, as well as definitions for `producer` and `consumer`.

## Kubernetes

### k8s/producer/deployment.yml

- kind: Deployment
- replicas: 1

### k8s/consumer/deployment.yml

- kind: StatefulSet
- replicas: 10

# What are the dependencies?

- Docker
- Kubernetes (optional)

# How do I build?

```shell
~/projects/kafka-static-membership # docker compose build
```

# How do I run?

```shell
~/projects/kafka-static-membership # make up service=kafka
~/projects/kafka-static-membership # docker compose up -d producer
~/projects/kafka-static-membership # docker compose up -d consumer
```

# How do I deploy?

```shell
~/projects/kafka-static-membership # make up service=kafka
~/projects/kafka-static-membership # kubectl apply -f k8s/producer/deployment.yml
~/projects/kafka-static-membership # kubectl apply -f k8s/consumer/deployment.yml
```

# How to observe static membership?

- Pod names are of the form `kafka-static-membership-<replica index>` (e.g., `kafka-static-membership-9`)
- No rebalancing in logs after pod restarts

# Further Reading

- Check out the blog post that accompanies this repository: https://www.appshapes.com/kafka-static-membership-rebalancing-and-kubernetes-stateful-set/
