**PHOTO SEARCH TEST TASK FOR AGILE ENGINE BY _DMYTRO CHERNIAIEV_**

Setup and run:

What do you need to run this project:
* Java 11
* Maven

Use _**mvn clean install spring-boot:run**_ to run application

When application is running, just call following endpoint:
curl --location --request GET 'http://localhost:8080/search/{searchTerm}'

How to improve?
* Move local variables to properties
* Improve search algorithm (For example, use ready-made solutions)
* Improve cache system and remake updating cache algorithm
