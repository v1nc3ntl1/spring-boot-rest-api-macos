# Before run application
Need to create schema "moneylion" in MySQL server before running the application.
Flyway will auto migrate tables.


# Endpoint example
**endpoint** : GET /feature?email=XXX&featureName=XXX  
**responseBody** :  
{  
"canAccess": true|false  
}  


**request** : POST /feature  
**requestBody** :  
{  
"featureName": "xxx",   
"email": "xxx",   
"enable": true|false  
}  
**responseHttpStatus** : 200/304  

To Access functionality in swagger
http://localhost:8090/swagger-ui/
