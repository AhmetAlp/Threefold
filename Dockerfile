FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
COPY threefold_codeassign.jar /home/spring/app/threefold_codeassign.jar
COPY threefold_codeassign_lib /home/spring/app/threefold_codeassign_lib
RUN chown -R spring:spring /home/spring/app
USER spring:spring
ENTRYPOINT ["java","-jar","/home/spring/app/threefold_codeassign.jar"]