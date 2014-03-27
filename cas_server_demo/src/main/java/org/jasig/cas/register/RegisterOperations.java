package org.jasig.cas.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class RegisterOperations extends HttpServlet{
		
	private static final long serialVersionUID = 6456436744230339514L;

	static Connection conn = null;
	static Statement st = null; 
    public void init() {
    	try {  
            //Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动 
            String fullPath = this.getServletContext().getRealPath("/WEB-INF/database.xml");

            ApplicationContext context = new FileSystemXmlApplicationContext(fullPath);
            DriverManagerDataSource dm = (DriverManagerDataSource)context.getBean("dataSource");
            conn = dm.getConnection();//.getConnection(  
                    //"jdbc:mysql://localhost:3306/cas_server_demo", "root", "abcd1234");// 创建数据连接  
              
        } catch (Exception e) {  
            System.out.println("数据库连接失败" + e.getMessage());  
        }  
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql = "select * from cas_server_demo.login where username='" + username + "'";
        PrintWriter out=response.getWriter();
        try {
        	st = (Statement) conn.createStatement();    
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				out.println("Username has been registered already. Please choose another usernmae.");
				return;
			}
			int hashIterations = 1000;
			RandomNumberGenerator saltGenerator = new SecureRandomNumberGenerator();
			ByteSource salt  = saltGenerator.nextBytes(64);//64bytes
			String saltString = salt.toBase64();
			System.out.println("username = " + username);
			System.out.println("saltString = " + saltString);
			String encodedPassword = new Sha512Hash(password, salt, hashIterations).toBase64();
			System.out.println("encodedPassword = " + encodedPassword);
			sql = "INSERT INTO cas_server_demo.login (username, encryptedPassword, salt) VALUES ('" + username +
					"', '" + encodedPassword + "', '" + saltString + "')";
			st.execute(sql);
			out.println("user [" + username + "] has been registered successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
}
