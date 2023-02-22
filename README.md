AWS Endpoint :
http://crudspringtestdeployaws-env.eba-cyptjabt.ap-northeast-1.elasticbeanstalk.com

Contoh hasil request:
https://drive.google.com/drive/folders/1vTs5LWGy4KeFiQrJJFPnp1pbuHM-haoy?usp=sharing

/api/v1/products

GET /api/v1/products
###
Get Products by ID
GET /api/v1/products/1
###
POST /api/v1/products
param :
Content-Type: application/json
{
"name" : "",
"stock" : 2
}
###
PUT localhost:8080/api/v1/products/1
Content-Type: application/json

{
"name" : "barang-update",
"stock" : 3
}
###
DELETE localhost:8080/api/v1/products/1
