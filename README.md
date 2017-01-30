# betterfy-web
Betterfy is an open source application for tracking habits and managing tasks.

#Endpoints

GET - http://localhost:8080/api/test : test endpoint just to verify if Jersey is working

POST - http://localhost:8080/api/authentication : in this endpoint the user receives its token if the email and password are correct

#Authentication
When the application receives the token it should send it in this format:

HEADER : VALUE
USER_ID : token

All users authenticate only with email and password, username is not supported in this system.
