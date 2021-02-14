## shopizer microservices ecosystem WIP

TODO rename repo to shopizer-microservices

### Requirements

Java 8

### Repo

Contains the following:

shopizer
shopizer-model
shopizer-catalogue-service
shopizer-catalogue-pricing-service
shopizer-catalogue-rdbms-starter

### Details

shopizer : parent BON
shopizer-common : Common model and utility
shopizer-catalogue-service : catalogend point
shopizer-catalogue-pricing-service : catalog-pricing end point
shopizer-catalogue-rdbms-starter : rdbms catalogue starter used by shopizer-catalogue-service

### From your IDE

Import shopizer as maven project
Import shopizer-common as maven project
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

