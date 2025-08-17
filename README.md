# Getting Started
The application consists in a implementation of cache-aside pattern with springboot, redis and postgresql. 

### Configuration
Before run the application it's necessary to do some steps.
1. Build the application using `mvn clean package`
2. Build the containers for docker `docker-compose up -d`
3. Then run the class `CacheAsideApplication`

### Test
There are some endpoint available in the application, basically a get and put endpoints to get the edit information from Category entity.
1. `curl --location 'http://localhost:8080/api/category/1'`
2. `curl --location --request PUT 'http://localhost:8080/api/category/1' \
   --header 'Content-Type: application/json' \
   --data '{
   "description":"Computers"
   }'`
