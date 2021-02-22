FROM artifactory.apps.bancolombia.com/devops/openjdk11-openj9:x86_64-alpine-jdk-11.0.3_7_openj9-0.14.3-slim
EXPOSE 8087
ADD build/*.jar app.jar
ENTRYPOINT java -jar -Duser.language=es -Duser.region=CO -Duser.timezone="America/Bogota" app.jar