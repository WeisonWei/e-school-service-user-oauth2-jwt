# e-school-service-user
e-school-service-user

## 1 init mongodb
docker exec -it f68db3938d99 sh
mongo
use admin
db.auth("root","123123")
show dbs
use userService
db.userService.insert({"name":"Weison"})
db.createUser({user:"us-app",pwd:"123456",roles:[{role:"dbOwner",db:"userService"}]})
#db.createUser({user:"us-app",pwd:"123456",roles:[{role:"dbOwner",db:"userService"}],mechanisms : ["SCRAM-SHA-256"] })
db.dropUser("us-app")


附：默认的端点 URL

    /oauth/authorize：授权端点
    /oauth/token：令牌端点
    /oauth/confirm_access：用户确认授权提交端点
    /oauth/error：授权服务错误信息端点
    /oauth/check_token：用于资源服务访问的令牌解析端点
    /oauth/token_key：提供公有密匙的端点，如果你使用 JWT 令牌的话

