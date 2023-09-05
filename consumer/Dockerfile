ARG PROJECT

FROM gradle:jdk17 AS builder
ARG PROJECT
COPY . /src
WORKDIR /src
RUN gradle --no-daemon --project-dir $PROJECT clean installDist

FROM openjdk:17-jdk-slim
ARG PROJECT
COPY --from=builder /src/$PROJECT/build/install/$PROJECT /app
WORKDIR /app

ENV PROJECT_ENV=$PROJECT
ENTRYPOINT bin/$PROJECT_ENV