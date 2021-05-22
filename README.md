# spring-boot-learning-note

## Introduction part

* mvn dependency:tree

> The mvn dependency:tree command prints a tree representation of your project dependencies

* @RestController

* @RequestMapping

> The @RestController and @RequestMapping annotations are Spring MVC annotations (they are not specific to Spring Boot)

* mvn spring-boot:run

> Since you used the spring-boot-starter-parent POM, you have a useful run goal that you can use to start the application

## Creating an Executable Jar (sometimes called “fat jars”)

* mvn package

> To create an executable jar, we need to add the spring-boot-maven-plugin to our pom.xml

```pom
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

* jar tvf target/demo-0.0.1-SNAPSHOT.jar

> If you want to peek inside the content of the builded jar file, you can use jar tvf

## 待補齊知識

* [Introduction to Servlets and Servlet Containers](https://www.baeldung.com/java-servlets-containers-intro)

* @EnableAutoConfiguration
