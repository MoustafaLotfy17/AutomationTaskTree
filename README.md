# STC Task

This is a repository for practicing Behavior Driven Development (BDD) using the Cucumber framework.

## What is BDD?

BDD is a software development approach that focuses on defining the behavior of a system in terms of user stories or scenarios. These scenarios are written in a plain language format that can be understood by both technical and non-technical stakeholders. BDD helps to align the development team with the business goals and ensure that the software meets the needs of its users.

## Getting Started

To run this project, you will need to have [Maven](https://maven.apache.org/) installed on your machine. Here are the steps to get started:

## Prerequisites

- Java 17
- Maven
- Chrome browser
- Allure
- Docker Desktop


1. Clone the repository:

       git clone https://github.com/AhmedYoussiif/STC_Task.git


2. Navigate to the project directory:
     
       cd STC_Task


3. Run the following command to build the project and run the tests:

       mvn clean test


3.1. If you want to run tests in parallel uncomment the comment in this file `src/test/java/runner/Runner.java`
then hit this command 

    mvn clean test

3.2. If you want to run on a selenium grid, follow instruction in docker-compose.yml file
, update `env` value at src/test/resources/configs/Configuration.properties file to be `remote` instead of local and hit this command

    mvn clean test -Dhost="localhost" -Dport="4444"
    
then navigate to this url to see sessions http://localhost:4444/



4.Open allure report:

    allure serve allure-results


This will compile the project, download any necessary dependencies, and run the Cucumber tests. You should see the results opened on your default browser.

## Contributing

If you would like to contribute to this project, please fork the repository and create a pull request with your changes. We welcome contributions from the community!

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
