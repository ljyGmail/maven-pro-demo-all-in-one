## 当MySQL数据库版本发生改变时，需要做出的修改

* Maven中对数据库的依赖(以MySQL9.1.0为例)
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.1.0</version>
</dependency>
```

* `jdbc.properties`文件中做如下修改:
```properties
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/db_imperial_court?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
username=root
password=445566hh
initialSize=10
maxActive=20
maxWait=10000
```
