curl http://localhost:9000/api/customers/0/10
curl http://localhost:9000/api/getCustomer/5f2c029e1c38720d70237232

For create a Customer with data, you may use curl with -d option for sending data, use -H option to set header content type
curl -d '{"name":"Ahmet","surname":"Alp","email":"ahmet.alp@altd.com","initials":"Mr","mobile": "+353895555555"}' -H 'Content-Type: application/json' http://localhost:9000/api/create
For updaye a Customer with data, you may use curl with -d option for sending data, use -H option to set header content type, use -X request type(PUT)
curl -d '{"name":"Ahmet","surname":"Alp","email":"ahmet.alp@altd.ie","initials":"Mr","mobile": "+353895555559"}' -H 'Content-Type: application/json' -X PUT http://localhost:9000/api/update/5f2c029e1c38720d70237232
For delete a Customer with id, use -X request type(DELETE)
curl -X DELETE http://localhost:9000/api/delete/5f2c029e1c38720d70237232


