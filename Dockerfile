# Образ, на основании которого я делаю свой образ
FROM openjdk:15
FROM maven

# копирую jar, который сгенерировал с помощью команды "mvn clean install -DskipTests=true"
# в контейнер

WORKDIR /home/app
COPY . .
RUN mvn clean install -DskipTests=true


# запуск jar файла при помощи команды java -jar app.jar
CMD ["java","-jar","/home/app/target/DB-0.0.1-SNAPSHOT.jar"]
