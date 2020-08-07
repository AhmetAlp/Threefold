# Threefold
The object is to create a linux container/image (docker) that will handle a full CRUDL microservice for a customer.

# Microservice Basic Authentication Security
For every process; **username:**user1 **password:**user1

# Microservice documentation
You can find microservice OPEN API definition at http://localhost:9000/swagger-ui.html

# Customer Query Usage with curl
Services are secured by basic authentication. username:user1 password:user1 
### Listing customers:
Listing customer records supports with pagination
> curl --user {username}:{password} http://localhost:9000/customerapi/customers/{pagenumber}/{size}
pagenumber is zero based. For the first page, please use 0
##### Example: List first page with page size 10
> curl --user user1:user1 http://localhost:9000/customerapi/customers/0/10

### Query customer details:
> curl --user {username}:{password} http://localhost:9000/customerapi/getCustomer/{idNumber}
##### Example: Get customer information for the customer has 5f2c029e1c38720d70237232 id
> curl --user user1:user1 http://localhost:9000/customerapi/getCustomer/5f2c029e1c38720d70237232

### Create a new customer:
For create a Customer with data, you may use curl with -d option for sending data, use -H option to set header content type
> curl --user {username}:{password} -d '{Customer JSON data}' -H 'Content-Type: application/json' http://localhost:9000/customerapi/create
##### Example: Create a customer whose name is Ahmet Alp
> curl --user user1:user1 -d '{"name":"Ahmet","surname":"Alp","email":"ahmet.alp@altd.com","initials":"Mr","mobile": "+353895555555"}' -H 'Content-Type: application/json' http://localhost:9000/customerapi/create

### Update a customer:
For update a Customer with data and customer id, you may use curl with -d option for sending data, use -H option to set header content type, use -X request type(PUT)
> curl --user {username}:{password} -d '{Customer JSON data}' -H 'Content-Type: application/json' -X PUT http://localhost:9000/customerapi/update/{customer id}
##### Example: Update customer Ahmet Alp phone number and email
> curl --user user1:user1 -d '{"name":"Ahmet","surname":"Alp","email":"ahmet.alp@altd.ie","initials":"Mr","mobile": "+353895555559"}' -H 'Content-Type: application/json' -X PUT http://localhost:9000/customerapi/update/5f2c029e1c38720d70237232

### Delete a customer
For delete a Customer with id, use -X request type(DELETE)
> curl --user {username}:{password} -X DELETE http://localhost:9000/customerapi/delete/{customer id}
##### Example: Delete a customer whose id is 5f2c029e1c38720d70237232
> curl --user user1:user1 -X DELETE http://localhost:9000/customerapi/delete/5f2c029e1c38720d70237232

