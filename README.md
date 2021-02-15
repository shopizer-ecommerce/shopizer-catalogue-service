## shopizer catalogue microservices ecosystem WIP

### Requirements

Java 8

### Repo

Contains the following:

shopizer
shopizer-common
shopizer-catalogue-service
shopizer-catalogue-pricing-service
shopizer-catalogue-rdbms-starter

### Details

shopizer is parent
shopizer-common common utility
shopizer-catalogue-service is a rest service
shopizer-catalogue-pricing-service is a rest service
shopizer-catalogue-service uses starter shopizer-catalogue-rdbms-starter for backend

### From your IDE

Import shopizer-catalogue-service as maven project
Import shopizer-catalogue-pricing-service as maven project
Import shopizer-catalogue-rdbms-starter as maven project


shopizer-catalogue-rdbms-starter parent contains spring-boot-starter and spring-boot-starter-autoconfigure

### IDE required plugins

Please install SonarLint plugin (code quality plugin)

https://www.sonarlint.org/eclipse
https://www.sonarlint.org/intellij/

Please install Google code formatter

https://github.com/google/styleguide/blob/gh-pages/eclipse-java-google-style.xml
https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml

### Project documentation

[Microservices technical documentation](https://github.com/shopizer-ecommerce/shopizer-catalogue-service/blob/main/docs/index.md)



