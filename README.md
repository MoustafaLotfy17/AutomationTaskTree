# Tree Task

Selenuim Task

## Getting Started

To run this project, you will need to have [Maven](https://maven.apache.org/) installed on your machine. Here are the steps to get started:

## Prerequisites

- Java 17
- Maven
- Chrome browser
- Allure
- Docker Desktop


1. If you want to run on a selenium grid, follow instruction in docker-compose.yml file
, update `env` value at src/test/resources/configs/Configuration.properties file to be `remote` instead of local and hit this command

    mvn clean test -Dhost="localhost" -Dport="4444"
    
then navigate to this url to see sessions http://localhost:4444/



2.Open allure report:

    allure serve allure-results


This will compile the project, download any necessary dependencies, and run the Cucumber tests. You should see the results opened on your default browser.

## Contributing

If you would like to contribute to this project, please fork the repository and create a pull request with your changes. We welcome contributions from the community!

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
