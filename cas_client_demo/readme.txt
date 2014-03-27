cas_client_demo说明文档
作者：赵冬
日期：20130910

cas_client_demo是用来演示cas系统单点登陆的基本功能的。
在本地MySQL数据库中导入cas_client_demo.sql文件，然后在eclipse中以existing maven project方式导入该项目。
利用wtp插件或者其他tomcat插件等在eclipse中运行该项目。

这里需要有几个注意的事项：
/cas_client_demo/src/main/resources/config/jdbc.properties
这个文件需要修改连接数据库的名称为实际值。

运行起来后在浏览器访问： http://localhost:8080/app
即可看到网页。可以点击注册和登陆测试。

该例子中采用了shiro集成cas的方式作为客户端使用，因为shiro可以简化一些客户端的操作。
几个重要的配置文件：
/cas_client_demo/src/main/resources/config/spring/shiro.xml
这个文件是存放shiro配置以及对应的cas filter拦截的url路径等信息。

