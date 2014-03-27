package org.jasig.cas.util;

/**
 * 
 * @description 这个接口主要是对cas已有接口PasswordEncoder添加salt支持 
 * @version 1.0  
 * @author 赵冬  
 * @createtime 2013年8月27日 上午10:12:44
 */
public interface PasswordSaltEncoder {
	/**
	 * 
	 * @param password 这里是password的原始明文密码
	 * @param saltBase64 这里是salt的Base64字符串
	 * @return  加密后的password密文
	 * @description 提供password的加密处理
	 * @version 1.0  
	 * @author 赵冬
	 * @createtime 2013年8月27日 上午10:13:45
	 */
	String encode(String password, String saltBase64);
}
