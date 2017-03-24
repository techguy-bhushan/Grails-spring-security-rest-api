# Grails-spring-security-rest-api-tutorial

Rest Api secure with spring security- Sample

This is a simple Spring Security REST Plugin tutorial where token-based  Authorization is used, app build on grails 2.4.3 version.
Here I am using roles 1: ROLE_ADMIN (who can see all the list of users/read all posts) 2: ROLE_USER (who can create the Posts/ read all post).
Anonymous user (who is not registered with application) can only read Posts.

Roles and Users are created in Bootstrap file'.
Api's path are mapped in Urlmapping file.
Spring REST Plugin configuration is available in Config file.

Run application : grails run-app

you can test this apis with curl request or postman.

e.g: test with curl request :
login user :-
curl  -H "Content-Type: application/json" -X POST -d '{"username":"bhushan","password":"password"}' http://localhost:9000/spring-rest-plugin-sample/api/login

o/p : {"username":"bhushan","roles":["ROLE_USER"],"token":"atqj5tjc3vn41nntsrrb7hgsahh66moc","token_type":"Bearer"}
