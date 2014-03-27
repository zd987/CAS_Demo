/**  
* @title SHA512PasswordEncoder.java  
* @package org.jasig.cas.util  
* @description SHA512PasswordEncoder的类实现 
* @author 赵冬  
* @createtime 2013年8月20日 下午3:50:09  
* @version 1.0  
*/
package org.jasig.cas.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;

/**  
 * @description 采用SH512算法的密码加密 
 * @version 1.0  
 * @author 赵冬  
 * @createtime 2013年8月20日 下午3:50:09  
 */
public class SHA512PasswordEncoder implements PasswordSaltEncoder  {

	private int iterationCount; 
    
    public int getIterationCount() {
        return iterationCount;
    }
    
    public void setIterationCount(int iterationCount) {
    	this.iterationCount = iterationCount;
    }
    
	/**  
	 * @param args  
	 * @description 单机测试用的函数 
	 * @version 1.0  
	 * @author 赵冬
	 * @createtime 2013年8月20日 下午3:50:09  
	 */
	public static void main(String[] args) {
		String password = "1234567890abcdefg";
		ByteSource salt = new SecureRandomNumberGenerator().nextBytes(64);
		long t1 = System.currentTimeMillis();
		new Sha512Hash(password, salt, 1000).toBase64();
		long t2 = System.currentTimeMillis();
		new Sha512Hash(password, salt, 1).toBase64();
		long t3 = System.currentTimeMillis();
		System.out.println("Iteration count: 1000, TimeMillis: " + (t2 - t1));
		System.out.println("Iteration count: 1, TimeMillis: " + (t3 - t2));
	}

	@Override
	/**
	 * 实际加密采用shiro提供的API。
	 */
	public String encode(String password, String saltBase64) {
		ByteSource salt = ByteSource.Util.bytes(Base64.decode(saltBase64));
		return new Sha512Hash(password, salt, iterationCount).toBase64();
	}

}
