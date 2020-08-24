# springboot-full-crud
A Spring Boot Crud Application with history different tech stacks and entities

**spring.io dependencies while creating the project**
 - web-start
 - jpa
 - dev-tools
 - oracle driver

**Techs**
- Db: oracle 12c
- hibernate: without PK
- app server: tomcat
- jackson json to POJO


#### First commit version
- Dao with hibernate implementation
- a service layer
- a rest controller

#### Second commit version
- Dao with standard JPA implementation
- a service layer
- a rest controller

#### Third commit version
- JPA repository (Do not need dao interfaces and impl's anymore)
- a service layer (refactored to JPA repo)
- a rest controller
