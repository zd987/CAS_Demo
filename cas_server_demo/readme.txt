cas_server_demo说明文档
作者：赵冬
日期：20130910

cas_server_demo是用来演示cas系统单点登陆的基本功能的。
在本地MySQL数据库中导入cas_server_demo.sql文件，然后在eclipse中以existing maven project方式导入该项目。
利用wtp插件或者其他tomcat插件等在eclipse中运行该项目。

这里需要有几个注意的事项：
cas_server_demo\src\main\webapp\WEB-INF\database.xml
这个文件需要修改连接数据库的名称为实际值。

运行起来后在浏览器访问： http://localhost:8080/cas
即可看到网页。可以点击注册和登陆测试。