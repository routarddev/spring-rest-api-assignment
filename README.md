# spring-rest-api-assignment Market Surveys API

Java REST API using Spring Boot Framework exposing CRUD methods via HTTP to manage market surveys.

Persistence with MongoDB.

- Main URL: http://localhost:8080/api/v1/
- API documentation: http://localhost:8080/api/v1/

- API Methods:
	- Create/Add (POST): create new market survey and add it to the surveys list
	- Retrieve/Get (GET):
		- Get full list of market surveys: http://localhost:8080/api/v1/surveys/
		- Get details of surveys related to some subject: http://localhost:8080/api/v1/surveys/subject/
	- Update (PUT): modify values of survey item with surveyId=N
		- PUT http://localhost:8080/api/v1/surveys/N/
	- Delete (DELETE): delete survey item with surveyId=N
		- DELETE http://localhost:8080/api/v1/surveys/N/
