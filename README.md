# spring-boot-learning-note

## Introduction part

* mvn dependency:tree

> The mvn dependency:tree command prints a tree representation of your project dependencies

* @RestController

* @RequestMapping

> The @RestController and @RequestMapping annotations are Spring MVC annotations (they are not specific to Spring Boot)

* mvn spring-boot:run

> Since you used the spring-boot-starter-parent POM, you have a useful run goal that you can use to start the application

### Creating an Executable Jar (sometimes called “fat jars”)

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

## Build systems using Spring Boot

### Dependency Management

* Maven
  * [Spring Boot Maven Plugin Documentation](https://docs.spring.io/spring-boot/docs/2.5.0/maven-plugin/reference/htmlsingle/#?.?)

* Gradle

### spring-boot-starter

> Starters are a set of convenient dependency descriptors that you can include in your application

* [The following application starters are provided by Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.build-systems.starters)

### Main class

* @SpringBootApplication: 是個複合annotaion包含了 @Configuration and @EnableAutoConfiguration and @ComponentScan annotations

  * @EnableAutoConfiguration: enable [Spring Boot’s auto-configuration mechanism](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.auto-configuration). Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.

  * @ComponentScan: enable @Component scan on the package where the application is located
  * @Configuration: allow to register extra beans in the context or import additional configuration classes

  ```JAVA
  @SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
  public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
  }
  ```

> If you structure your code as suggested above (locating your application main class in a top package), you can add **@ComponentScan** without any arguments or use the **@SpringBootApplication** annotation which implicitly includes it. All of your application components (@Component, @Service, @Repository, @Controller etc.) are automatically registered as Spring Beans

## Spring Boot Features

### SpringApplication

#### Startup

* Startup information logging can be turned off by setting **spring.main.log-startup-info** to false. This will also turn off logging of the application’s active profiles

* **java -jar** myproject-0.0.1-SNAPSHOT.jar **--debug** could open debug mode

#### Lazy Initialization

> When lazy initialization is enabled, beans are created as they are needed rather than during application startup, lazy initialization is **not enabled by default**.

* 優點
  1. reduce the time that it takes your application to start

* 缺點
  1. delay the discovery of a problem with the application
  2. 必須考慮到JVM has sufficient memory to accommodate all of the application’s beans

> Lazy initialization can be enabled programmatically using the lazyInitialization method on SpringApplicationBuilder or the setLazyInitialization method on SpringApplication or properties

```PROPERTIES
spring.main.lazy-initialization=true
```

> **Tip** If you want to disable lazy initialization for certain beans while using lazy initialization for the rest of the application, you can explicitly set their lazy attribute to false using the **@Lazy(false)** annotation

## Spring Guides Practice

### Building a RESTful Web Service

* @RestController

> @RestController annotation, which marks the class as a controller where **every method returns a domain object instead of a view**. It is shorthand for including both @Controller and @ResponseBody

#### 傳統MVC controller return a view

#### RESTful controller return a object data

> A key difference between a traditional MVC controller and the RESTful web service controller shown earlier is the way that the HTTP response body is created. Rather than relying on a view technology to perform server-side rendering of the greeting data to HTML, this **RESTful web service controller populates and returns a object. The object data will be written directly to the HTTP response as JSON**

#### Spring會自動將Object轉成JSON格式

> A plain old Java object must be converted to JSON. Thanks to Spring’s HTTP message converter support, you need not do this conversion manually. **Because Jackson 2 is on the classpath, Spring’s MappingJackson2HttpMessageConverter is automatically chosen to convert the Greeting instance to JSON**

## 待補齊知識

* [Introduction to Servlets and Servlet Containers](https://www.baeldung.com/java-servlets-containers-intro)

* @Configuration, @ConfigurationProperties, @PropertySource, @ImportResource 之間的差異與使用時機

* Get deeper into @EnableAutoConfiguration [Spring Boot’s auto-configuration mechanism](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.auto-configuration)

* [Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/docs/2.5.0/maven-plugin/reference/htmlsingle/#?.?)

* [Spring Boot Actuator: Production-ready Features](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.enabling)

* JVM hot-swapping
