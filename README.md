# SpringBoot-MS-templates
Backup working microservices templates

## Description
MicroService architecture samples with h2 / mongoDb / mySQL databases on the one hand, and with Zuul-Eureka  with mySQL on the other hand.
Requests through POSTMAN / swagger-ui.

## Getting Started

### Dependencies

* Java 11
* MavenServer
* MongoDb
* SQLServer
* any IDE

### Installing

* H2 & MongoDB related folders
   * Clone repository
   * Modify related application.properties values to fit your credentials
* Zuul & Eureka related architecture
   * Fork the repository
   * Modify each microservices-{folderName}.properties values in main git folder to fit your SQL credentials
   * Create local appropriate SQL databases (such as insured_db, contract_db and so on)

### Executing program

* Maven build skipping tests (not implemented)
```
mvn clean install -DskipTests=true 
```
* Launch order
```
config-server
eureka-server
microservices
zuul-server
```

## Authors

* [@Farah404](https://github.com/Farah404)
* [@Brl101](https://github.com/ArkT840)

## Version History

* 0.1
    * Initial Release
