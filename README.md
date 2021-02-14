# spring-boot-rest-api-secure-oracle
- spring boot application demonstrating simple rest endpoint to persist data in Oracle DB using JPA
- The API is secured by basic authentication implemented using spring security.
- Credentials are read from application.properties.
- Given below are few cURL commands that can be used to test the api.

###### wrong username
```ruby
curl -i -u anan:C0mpl3* -H "Content-Type: application/json" -XPOST http://localhost:8080/employee-service/api/v1/journal/employees -d "{\"employeeId\":\"2222\",\"firstName\":\"Anand1\",\"lastName\":\"Technical1\",\"email\":\"anand.technical@test.com\",\"dob\":\"02-02-1981\",\"phNumber\":\"222-331\"}"
```

###### wrong password
```ruby
> curl -i -u anand:C0mp -H "Content-Type: application/json" -XPOST http://localhost:8080/employee-service/api/v1/journal/employees -d "{\"employeeId\":\"2222\",\"firstName\":\"Anand1\",\"lastName\":\"Technical1\",\"email\":\"anand.technical@test.com\",\"dob\":\"02-02-1981\",\"phNumber\":\"222-331\"}"
```

###### Employee Id is not numeric
> curl -i -u anand:C0mpl3* -H "Content-Type: application/json" -XPOST http://localhost:8080/employee-service/api/v1/journal/employees -d "{\"employeeId\":\"22a22\",\"firstName\":\"Anand1\",\"lastName\":\"Technical1\",\"email\":\"anand.technical@test.com\",\"dob\":\"02-02-1981\",\"phNumber\":\"222-331\"}"

###### Employee Id is missing
> curl -i -u anand:C0mpl3* -H "Content-Type: application/json" -XPOST http://localhost:8080/employee-service/api/v1/journal/employees -d "{\"firstName\":\"Anand1\",\"lastName\":\"Technical1\",\"email\":\"anand.technical@test.com\",\"dob\":\"02-02-1981\",\"phNumber\":\"222-331\"}"

###### Invalid email id format
> curl -i -u anand:C0mpl3* -H "Content-Type: application/json" -XPOST http://localhost:8080/employee-service/api/v1/journal/employees -d "{\"employeeId\":\"2222\",\"firstName\":\"Anand1\",\"lastName\":\"Technical1\",\"email\":\"anand.technical\",\"dob\":\"02-02-1981\",\"phNumber\":\"222-331\"}"

###### Email id is missing
> curl -i -u anand:C0mpl3* -H "Content-Type: application/json" -XPOST http://localhost:8080/employee-service/api/v1/journal/employees -d "{\"employeeId\":\"2222\",\"firstName\":\"Anand1\",\"lastName\":\"Technical1\",\"dob\":\"02-02-1981\",\"phNumber\":\"222-331\"}"

###### Successful request
> curl -i -u anand:C0mpl3* -H "Content-Type: application/json" -XPOST http://localhost:8080/employee-service/api/v1/journal/employees -d "{\"employeeId\":\"3333\",\"firstName\":\"Anand1\",\"lastName\":\"Technical1\",\"email\":\"anand.technical@test.com\",\"dob\":\"02-02-1981\",\"phNumber\":\"222-331\"}"


