# menu-management-system
Menu management system app.

# Project structure

                a       menu-management-system-pom 
                |
                |__ b   menu-domain
                |
                |
                \__ c   menu-services

+ [a] This is top pom that manages all dependencies and biulds other modules.
+ [b] Menu domain project contains entity classes that are represented as tables in relational database.
+ [c] Menu services contains service layer implementations and other api's.

# Building project

### 1. Install Maven
Download maven from here: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi) apache-maven-3.5.0-bin.zip. Extract the files in desired directory. And add bin folder (example: C:\Program Files\Apache Software\apache-maven-3.5.0\bin) to your system PATH variable.

### 2. Run command
Run command line from menu-management-system dir: mvn clean install

It will get all dependencies and build project files and also run integration tests.
Now import project files to your IDE.
