FROM moxm/java:1.8-full

RUN mkdir -p /web-demo

WORKDIR /web-demo

ARG JAR_FILE=target/web-demo.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"

CMD java -jar app.jar $JAVA_OPTS


