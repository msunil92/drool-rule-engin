# Drool-Rule-Engine

### Steps to start:

* docker-compose up -d


*   Endpoints
    ```
    GET: http://localhost:8080/customer
    
    GET: http://localhost:8080/customer_drl
    
    POST: http://localhost:8080/customer
        {
            "name" : "Sunil",
            "type": "PLATINUM",
            "bond": 81
        }
    
    
    POST: http://localhost:8080/customer_drl
        {
            "name" : "Sunil",
            "type": "PLATINUM",
            "bond": 7
        }
    ```
