# **Java API Assessment - Coffee Inventory API**

## **Project Overview**
This API streamlines the management of coffee inventory for small business owners, by providing users with essential operations such as creating, updating, or deleting coffees, along with retrieving coffee information. Furthermore, it offers the capability to retrieve a sorted list of all stored coffees, sorted from least expensive to most expensive. Designed specifically for coffee shop owners, this API serves as an effective tool for checking and monitoring coffee inventory with ease.

## **Features**

* Retrieve Coffees: View the list of available coffees in the inventory.
* Retrieve: Coffees View the list of avaliable coffees in the inventory in sorted order. 
* Retrieve Coffee by id: View a specific coffee in the inventory.
* Add Coffee: Add a new coffee to the inventory.
* Update Coffee: Modify the details of an existing coffee.
* Delete Coffee: Remove coffee from the inventory.


### **Prerequisites**

* Java 17: Ensure Java is installed on your machine. https://www.oracle.com/java/technologies/downloads/ 
* Terminal/Command Line: A command-line interface is required to interact with the application.
* Postman: To test and perform API operations, you can use Postman. Download it here https://www.postman.com/downloads/
* Maven 3.8.4 or higher: Maven is a build and project management tool. You can download it from the official Apache Maven website.


## **Getting Started**

* Go to https://github.com/paulajade17/java-api-assessment
* Click on the green Code button and clone SSH the repository URL
* Open your terminal or command prompt:

For Mac

```plaintext
Click the Launchpad icon in the Dock, type Terminal in the search field, then click Terminal.
```
For Windows

```plaintext
Click start and search “Command Prompt”
```

* Cd into your desired directory i.e. Downloads
* Run git clone command:
* Git clone git@github.com:paulajade17/java-api-assessment.git
* You should see the below if it has been cloned  successfully

```sh
Cloning into 'java-api-assessment'...
remote: Enumerating objects: 378, done.
remote: Counting objects: 100% (325/325), done.
remote: Compressing objects: 100% (185/185), done.
remote: Total 378 (delta 94), reused 274 (delta 78), pack-reused 53
Receiving objects: 100% (378/378), 119.31 KiB | 504.00 KiB/s, done.
Resolving deltas: 100% (95/95), done.
```
* Cd java-api-assesment 

## Install Dependencies ##

Run the following command to compile the project using Maven on mac:

```
./mvnw clean dependency:resolve
```
If you are on a Windows machine, that will be:
```
mvnw clean dependency:resolve
```
```sh
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ api-assessment ---
[INFO] 
[INFO] --- dependency:3.5.0:resolve (default-cli) @ api-assessment ---
[INFO] 
[INFO] The following files have been resolved:
[INFO]    org.springframework.boot:spring-boot-starter-web:jar:3.1.4:compile -- module spring.boot.starter.web [auto]
[INFO]    org.springframework.boot:spring-boot-starter:jar:3.1.4:compile -- module spring.boot.starter [auto]
[INFO]    org.springframework.boot:spring-boot-starter-logging:jar:3.1.4:compile -- module spring.boot.starter.logging [auto]
[INFO]    ch.qos.logback:logback-classic:jar:1.4.11:compile -- module ch.qos.logback.classic
[INFO]    ch.qos.logback:logback-core:jar:1.4.11:compile -- module ch.qos.logback.core
[INFO]    org.apache.logging.log4j:log4j-to-slf4j:jar:2.20.0:compile -- module org.apache.logging.slf4j [auto]
[INFO]    org.apache.logging.log4j:log4j-api:jar:2.20.0:compile -- module org.apache.logging.log4j
[INFO]    org.slf4j:jul-to-slf4j:jar:2.0.9:compile -- module jul.to.slf4j
[INFO]    jakarta.annotation:jakarta.annotation-api:jar:2.1.1:compile -- module jakarta.annotation
[INFO]    org.yaml:snakeyaml:jar:1.33:compile -- module org.yaml.snakeyaml [auto]
[INFO]    org.springframework.boot:spring-boot-starter-json:jar:3.1.4:compile -- module spring.boot.starter.json [auto]
[INFO]    com.fasterxml.jackson.core:jackson-databind:jar:2.15.2:compile -- module com.fasterxml.jackson.databind
[INFO]    com.fasterxml.jackson.core:jackson-annotations:jar:2.15.2:compile -- module com.fasterxml.jackson.annotation
[INFO]    com.fasterxml.jackson.core:jackson-core:jar:2.15.2:compile -- module com.fasterxml.jackson.core
[INFO]    com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.15.2:compile -- module com.fasterxml.jackson.datatype.jdk8
[INFO]    com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.15.2:compile -- module com.fasterxml.jackson.datatype.jsr310
[INFO]    com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.15.2:compile -- module com.fasterxml.jackson.module.paramnames
[INFO]    org.springframework.boot:spring-boot-starter-tomcat:jar:3.1.4:compile -- module spring.boot.starter.tomcat [auto]
[INFO]    org.apache.tomcat.embed:tomcat-embed-core:jar:10.1.13:compile -- module org.apache.tomcat.embed.core
[INFO]    org.apache.tomcat.embed:tomcat-embed-el:jar:10.1.13:compile -- module org.apache.tomcat.embed.el
[INFO]    org.apache.tomcat.embed:tomcat-embed-websocket:jar:10.1.13:compile -- module org.apache.tomcat.embed.websocket
[INFO]    org.springframework:spring-web:jar:6.0.12:compile -- module spring.web [auto]
[INFO]    org.springframework:spring-beans:jar:6.0.12:compile -- module spring.beans [auto]
[INFO]    io.micrometer:micrometer-observation:jar:1.11.4:compile -- module micrometer.observation [auto]
[INFO]    io.micrometer:micrometer-commons:jar:1.11.4:compile -- module micrometer.commons [auto]
[INFO]    org.springframework:spring-webmvc:jar:6.0.12:compile -- module spring.webmvc [auto]
[INFO]    org.springframework:spring-aop:jar:6.0.12:compile -- module spring.aop [auto]
[INFO]    org.springframework:spring-context:jar:6.0.12:compile -- module spring.context [auto]
[INFO]    org.springframework:spring-expression:jar:6.0.12:compile -- module spring.expression [auto]
[INFO]    org.springframework.boot:spring-boot-devtools:jar:3.1.4:runtime (optional) -- module spring.boot.devtools [auto]
[INFO]    org.springframework.boot:spring-boot:jar:3.1.4:compile -- module spring.boot [auto]
[INFO]    org.springframework.boot:spring-boot-autoconfigure:jar:3.1.4:compile -- module spring.boot.autoconfigure [auto]
[INFO]    org.springframework.boot:spring-boot-starter-test:jar:3.1.4:test -- module spring.boot.starter.test [auto]
[INFO]    org.springframework.boot:spring-boot-test:jar:3.1.4:test -- module spring.boot.test [auto]
[INFO]    org.springframework.boot:spring-boot-test-autoconfigure:jar:3.1.4:test -- module spring.boot.test.autoconfigure [auto]
[INFO]    com.jayway.jsonpath:json-path:jar:2.8.0:test -- module json.path (auto)
[INFO]    org.slf4j:slf4j-api:jar:2.0.9:compile -- module org.slf4j
[INFO]    jakarta.xml.bind:jakarta.xml.bind-api:jar:4.0.1:test -- module jakarta.xml.bind
[INFO]    jakarta.activation:jakarta.activation-api:jar:2.1.2:test -- module jakarta.activation
[INFO]    net.minidev:json-smart:jar:2.4.11:test -- module json.smart (auto)
[INFO]    net.minidev:accessors-smart:jar:2.4.11:test -- module accessors.smart (auto)
[INFO]    org.ow2.asm:asm:jar:9.3:test -- module org.objectweb.asm
[INFO]    org.assertj:assertj-core:jar:3.24.2:test -- module org.assertj.core
[INFO]    org.hamcrest:hamcrest:jar:2.2:test -- module org.hamcrest [auto]
[INFO]    org.junit.jupiter:junit-jupiter:jar:5.9.3:test -- module org.junit.jupiter
[INFO]    org.junit.jupiter:junit-jupiter-api:jar:5.9.3:test -- module org.junit.jupiter.api
[INFO]    org.opentest4j:opentest4j:jar:1.2.0:test -- module org.opentest4j
[INFO]    org.junit.platform:junit-platform-commons:jar:1.9.3:test -- module org.junit.platform.commons
[INFO]    org.apiguardian:apiguardian-api:jar:1.1.2:test -- module org.apiguardian.api
[INFO]    org.junit.jupiter:junit-jupiter-params:jar:5.9.3:test -- module org.junit.jupiter.params
[INFO]    org.junit.jupiter:junit-jupiter-engine:jar:5.9.3:test -- module org.junit.jupiter.engine
[INFO]    org.junit.platform:junit-platform-engine:jar:1.9.3:test -- module org.junit.platform.engine
[INFO]    org.mockito:mockito-junit-jupiter:jar:5.3.1:test -- module org.mockito.junit.jupiter [auto]
[INFO]    org.skyscreamer:jsonassert:jar:1.5.1:test -- module jsonassert (auto)
[INFO]    com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test -- module android.json (auto)
[INFO]    org.springframework:spring-core:jar:6.0.12:compile -- module spring.core [auto]
[INFO]    org.springframework:spring-jcl:jar:6.0.12:compile -- module spring.jcl [auto]
[INFO]    org.springframework:spring-test:jar:6.0.12:test -- module spring.test [auto]
[INFO]    org.xmlunit:xmlunit-core:jar:2.9.1:test -- module org.xmlunit [auto]
[INFO]    com.google.code.gson:gson:jar:2.10.1:compile -- module com.google.gson
[INFO]    org.mockito:mockito-core:jar:5.3.1:compile -- module org.mockito [auto]
[INFO]    net.bytebuddy:byte-buddy:jar:1.14.8:compile -- module net.bytebuddy
[INFO]    net.bytebuddy:byte-buddy-agent:jar:1.14.8:compile -- module net.bytebuddy.agent
[INFO]    org.objenesis:objenesis:jar:3.3:runtime -- module org.objenesis [auto]
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.656 s
[INFO] Finished at: 2024-02-07T19:33:54Z
[INFO] ------------------------------------------------------------------------
```
### **Running the Application**
- Run the following command on mac:
```
./mvnw spring-boot:run
```
* Or this if you are on a Windows machine:

```
mvnw spring-boot:run
```
* You should see the following script below if run successfully

```sh
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot:3.1.4:run (default-cli) > test-compile @ api-assessment >>>
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ api-assessment ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ api-assessment ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 10 source files with javac [debug release 17] to target/classes
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ api-assessment ---
[INFO] skip non existing resourceDirectory /Users/paulasemakula-buuza/Downloads/tests/java-api-assessment/src/test/resources
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ api-assessment ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] Compiling 1 source file with javac [debug release 17] to target/test-classes
[INFO] 
[INFO] <<< spring-boot:3.1.4:run (default-cli) < test-compile @ api-assessment <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot:3.1.4:run (default-cli) @ api-assessment ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.4)

2024-02-07T19:41:26.076Z  INFO 3867 --- [  restartedMain] com.cbfacademy.apiassessment.App         : Starting App using Java 17.0.9 with PID 3867 (/Users/paulasemakula-buuza/Downloads/tests/java-api-assessment/target/classes started by paulasemakula-buuza in /Users/paulasemakula-buuza/Downloads/tests/java-api-assessment)
2024-02-07T19:41:26.077Z  INFO 3867 --- [  restartedMain] com.cbfacademy.apiassessment.App         : No active profile set, falling back to 1 default profile: "default"
2024-02-07T19:41:26.094Z  INFO 3867 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2024-02-07T19:41:26.094Z  INFO 3867 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2024-02-07T19:41:26.375Z  INFO 3867 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2024-02-07T19:41:26.379Z  INFO 3867 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-02-07T19:41:26.379Z  INFO 3867 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.13]
2024-02-07T19:41:26.398Z  INFO 3867 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-02-07T19:41:26.399Z  INFO 3867 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 303 ms
2024-02-07T19:41:26.501Z  INFO 3867 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2024-02-07T19:41:26.512Z  INFO 3867 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2024-02-07T19:41:26.515Z  INFO 3867 --- [  restartedMain] com.cbfacademy.apiassessment.App         : Started App in 0.544 seconds (process running for 0.687)

```
## **Access the API Online**

The API is hosted online, and you can access it using Postman

* Open your browser and navigate to the base URL: https:// localhost:8080/api/coffees
* You should see a similar JSON objects like the one below
* To view the data in a sorted order from lowest to highest price, please use the following URL: https://localhost:8080/api/coffees?sortBy=price
```
[
{
"id": "afe40205-0625-42f1-aa4e-b8a545afbba1",
"name": "Caramel",
"description": "delicious caramel coffee",
"price": 1.99,
"brand": "Java's Cup",
"origin": "India"
},
{
"id": "46bcf09a-f6fc-4ac3-9961-1b133f6aa90e",
"name": "Spicy Sensation",
"description": "coffee infused with spicy chillies",
"price": 9.99,
"brand": "Coffee club",
"origin": "India"
},
{
"id": "8f99f192-7c14-4330-81a6-abac9ba07738",
"name": "Mint Chocolate",
"description": "hints of mint and chocolate",
"price": 5.99,
"brand": "Nescafe",
"origin": "Columbia"
},
{
"id": "9ba1f5e4-6b14-4828-95b4-4fa0bbeee0ac",
"name": "Dark Roast",
"description": "A strong and rich taste",
"price": 4.99,
"brand": "Nescafe",
"origin": "Indonesia"
},
{
"id": "510e9f44-7ee4-4f25-9964-22c0788d884e",
"name": "Americano",
"description": "Bold and dark flavours",
"price": 4.99,
"brand": "Nescafe",
"origin": "Brazil"
},
{
"id": "b04b2e41-f511-4879-b09f-03a1f5f50d0f",
"name": "Original",
"description": "A signature flavour",
"price": 2.99,
"brand": "Beanies",
"origin": "Columbia"
},
]
```

## Endpoints

| Endpoint                           | Description                                               | Parameters                                            |
|------------------------------------|-----------------------------------------------------------|-------------------------------------------------------|
| `GET /api/coffees`                 | Retrieve a list of all coffees or retrieves list in a sorted order by price.      | `sortBy`: string (Optional, Default: "defaultSort")   |
| `GET /api/coffees/{id}`            | Retrieve a specific coffee by its ID.                     | `id`: UUID (Required)                                |
| `POST /api/coffees`                | Create a new coffee.                                      | `name`: string (Required),<br> `price`: double (Required), <br> `description`: string (Optional) <br> `origin`: string (Optional) |
| `PUT /api/coffees/{id}`            | Update an existing coffee by ID.                          | `id`: UUID (Required),<br> `updatedCoffee`: Coffee object (Request body) |
| `DELETE /api/coffees/{id}`         | Delete a coffee by ID.                                    | `id`: UUID (Required)                                |


## **Access the API with POSTMAN**

* Launch the POSTMAN application on your computer or create an account on the website https://www.postman.com/
* Once logged in you should be directed to the home page
* Select "Workspaces" drop down in the top left corner
* Select My Workspace
* Select the + button and select create from template "REST API basics"

### GET Request ###
#### Get All Coffees ####
* Set the request type to GET
* Enter the URL for the endpoint https://localhost:8080/api/coffees
* Click send to send the request and retrieve the list of coffees.

#### Get All Coffees sorted by price #### 
* Set the request type to GET
* Enter the URL for the endpoint https://localhost:8080/api/coffees?sortBy=price
* Click send to send the request and retrieve the list of coffees.

#### Get Coffee by ID ####


### POST Request ###
* Set the request type to POST
* Enter the URL for the endpoint: http://localhost:3000/coffees
* In the request body, provide the details of the new coffee in JSON format. The attributes, will be name, description, price and origin
* You do not set the id as this is generated randomly
* An example of the JSON format will be shown below
* Once happy with the details click send to send the request and create a new coffee. 
```
{
    "name": "Latte",
    "description": "delicious Latte",
    "price": 3.99,
    "origin": "India"
}
```

### PUT Request ###
* Set the request type to PUT
* Enter the URL for the endpoint: http://localhost:3000/coffees/{id}
* Replace {id} with the id of the coffee you want to update
* In the request body, provide the updated details of the coffee in JSON format. An example will be shown below
* Once happy with the details click send to send the request and update the specified coffe.
```
{
    "name": "Latte",
    "description": "delicious Latte",
    "price": 3.99,
    "origin": "India"
}
```


### DELETE Request ###
* Set the request type to DELETE
* Enter the URL for the endpoint: http://localhost:3000/coffees/
* Enter the URL for the endpoint: http://localhost:3000/coffees/{id} 
* Replace {id} with the id of the coffee you want to delete
* Click send to send the request and create a new coffee


