/**  
* @title QueryDatabaseAuthenticationHandlerWithSalt.java  
* @package org.jasig.cas.util  
* @description QueryDatabaseAuthenticationHandlerWithSalt的类实现 
* @author 赵冬  
* @createtime 2013年8月26日 下午4:34:38  
* @version 1.0  
*/
package org.jasig.cas.util;

import java.util.Map;

import org.jasig.cas.adaptors.jdbc.AbstractJdbcUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import javax.validation.constraints.NotNull;

/**  
* @title QueryDatabaseAuthenticationHandlerWithSalt.java  
* @package org.jasig.cas.util  
* @description 这个类主要是完善了CAS提供的默认类QueryDatabaseAuthenticationHandler的功能
* 添加了对Salt的支持   
* @author 赵冬  
* @createtime 2013年8月26日 下午4:34:38  
* @version 1.0  
*/
public class QueryDatabaseAuthenticationHandlerWithSalt extends AbstractJdbcUsernamePasswordAuthenticationHandler {
	private static Logger log = LoggerFactory.getLogger(QueryDatabaseAuthenticationHandlerWithSalt.class);

	@NotNull
    private String sql;
    
    @NotNull
    private String passwordColumnName; 
    
    @NotNull
    private String saltColumnName;
    
    @NotNull
    private PasswordSaltEncoder passwordSaltEncoder; 


    /**
     * 这个类是抽象类中函数的实现，完成实际的密码验证工作。
     */
    @Override
    protected final boolean authenticateUsernamePasswordInternal(final UsernamePasswordCredentials credentials) throws AuthenticationException {
        final String username = getPrincipalNameTransformer().transform(credentials.getUsername());
        final String password = credentials.getPassword();
        
        try {
            final Map<String, Object> dataMap = getJdbcTemplate().queryForMap(this.sql, username);
            if(log.isDebugEnabled()){
                for(String key : dataMap.keySet()){
                	log.debug("Key: {}, Value: {}", key, dataMap.get(key));
                }
            }
            String saltBase64 = (String) dataMap.get(saltColumnName);
            String dbPassword = (String) dataMap.get(passwordColumnName);
            String encryptedPassword = this.getPasswordSaltEncoder().encode(password, saltBase64);
            log.debug("db: {}, encrypt: {}", dbPassword, encryptedPassword);
            return dbPassword.equals(encryptedPassword);
        } catch (final IncorrectResultSizeDataAccessException e) {
            // this means the username was not found.
            return false;
        }
    }

    /**
     * @param sql The sql to set.
     */
    public void setSql(final String sql) {
        this.sql = sql;
    }
    
    public void setPasswordColumnName(final String passwordColumnName) {
        this.passwordColumnName = passwordColumnName;
    }
    
    public void setSaltColumnName(final String saltColumnName) {
        this.saltColumnName = saltColumnName;
    }
    
    public void setPasswordSaltEncoder(PasswordSaltEncoder passwordSaltEncoder){
    	this.passwordSaltEncoder = passwordSaltEncoder;
    }
    
    public PasswordSaltEncoder getPasswordSaltEncoder(){
    	return this.passwordSaltEncoder;
    }
}
