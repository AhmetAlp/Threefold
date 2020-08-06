# Threefold
The object is to create a linux container/image (docker) that will handle a full CRUDL microservice for a customer.

# Microservice documentation
You can find microservice OPEN API definition at http://localhost:9000/swagger-ui.html

# Customer Query Usage with curl
Listing customers:
Listing custumer records supports with pagination
curl http://localhost:9000/api/customers/{pagenumber}/{size}
pagenumber is zero based. For the first page, please use 0
Example: List first page with page size 10
curl http://localhost:9000/api/customers/0/10

Query customer details:
curl http://localhost:9000/api/getCustomer/{idNumber}
Example: Get customer information for the customer has 5f2c029e1c38720d70237232 id
curl http://localhost:9000/api/getCustomer/5f2c029e1c38720d70237232

Create a new customer:
For create a Customer with data, you may use curl with -d option for sending data, use -H option to set header content type
curl -d '{Customer JSON data}' -H 'Content-Type: application/json' http://localhost:9000/api/create
Example: Create a customer whose name is Ahmet Alp
curl -d '{"name":"Ahmet","surname":"Alp","email":"ahmet.alp@altd.com","initials":"Mr","mobile": "+353895555555"}' -H 'Content-Type: application/json' http://localhost:9000/api/create

Update a customer:
For update a Customer with data and customer id, you may use curl with -d option for sending data, use -H option to set header content type, use -X request type(PUT)
curl -d '{Customer JSON data}' -H 'Content-Type: application/json' -X PUT http://localhost:9000/api/update/{customer id}
Example: Update customer Ahmet Alp phone number and email
curl -d '{"name":"Ahmet","surname":"Alp","email":"ahmet.alp@altd.ie","initials":"Mr","mobile": "+353895555559"}' -H 'Content-Type: application/json' -X PUT http://localhost:9000/api/update/5f2c029e1c38720d70237232

Delete a customer
For delete a Customer with id, use -X request type(DELETE)
curl -X DELETE http://localhost:9000/api/delete/{customer id}
curl -X DELETE http://localhost:9000/api/delete/5f2c029e1c38720d70237232


