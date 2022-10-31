# cms-application

### Dockerized cms boot application
#### Dockerfile - explained
```
FROM: As the base for our image, we'll take the Java-enabled Alpine Linux created in the previous section.
ENV: Environment variables
WORKDIR: Base directory
EXPOSE: port on which the application should run
COPY: We let Docker copy our jar file into the image.
ENTRYPOINT: This will be the executable to start when the container is booting. We must define them as JSON-Array because we'll use an ENTRYPOINT in combination with a CMD for some application arguments.
```
#### docker commands:
```
docker build -t cmsbootdocker3mar22:1.0.0-SNAP .
docker images | grep cmsbootdocker
docker run -d --name cmsbootdocker3marcontainer -p 8887:8080 cmsbootdocker3mar22:1.0.0-SNAP` hostPort:containerPort
docker ps -a
docker logs -f cmsbootdocker3marcontainer
docker stop cmsbootdocker3marcontainer
docker rm cmsbootdocker3marcontainer
```

### Running using command line from pom.xml level
`mvn spring-boot:run`

### Sept17-JAXBContext added

`Implemented JAXB by creating instance of JAXBcontext for 
CustomerResponse.class for mapping JavaObject to XML Response`

### Sept18-Postgresql-database
swagger-http://localhost:8099/swagger-ui.html

`Download install postgresql on local with same creds as property file,
Create schema using pgsql , Add postgresql dependency, update props
`

#### Sept21-SpringBoot JDBC Template
```
List<User> findAll() { jdbcTemplate.query("select * from users",
new UserRowMapper())};
UserRowMapper implements RowMapper<DefinedObject> and @Override mapRow(Resultset rs, int rowNumber){
user.setId(rs.getId("Id"))}
```

##### Reference
https://www.bezkoder.com/spring-boot-postgresql-example/

#### Sequels
```SELECT schema_name FROM information_schema.schemata;
SELECT * FROM information_schema.tables WHERE table_schema = 'customer_management_app';
SELECT * FROM information_schema.tables where table_schema ='public';
select * from customer_management_app.customer;

CREATE SCHEMA IF NOT EXISTS customer_management_app;
insert into customer_management_app.customer values (1, 'sai@saibaba.com', 'saibaba', 'gurusai');
insert into customer_management_app.customer values (2, 'chanda@sairam.com', 'chandaSai', 'chanda');
insert into customer_management_app.customer values (3, 'om@om.com', 'omalwaysom', 'omway');
```

##### Reference
https://www.bezkoder.com/spring-boot-postgresql-example/

Cacheable logs refer:
```
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%msg%n</pattern>
        </encoder>
    </appender>

    <logger name="org.springframework.cache" level="trace">
        <appender-ref ref="STDOUT" />
    </logger>
</configuration>
```
