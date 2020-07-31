#PHOTO SEARCH TEST TASK FOR AGILE ENGINE
###DMYTRO CHERNIAIEV
##Setup and run
What do you need to run this project:
* Java 11
* Maven

Use _**mvn clean install spring-boot:run**_ to run application

When application is running, just call following endpoint:
curl --location --request GET 'http://localhost:8080/search/{searchTerm}'
