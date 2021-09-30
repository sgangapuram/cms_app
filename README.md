# cms-application

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

