package are.you.ok.entry;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

public class EncryHelper {

	private String first_algorithmName = "SHA-512";
	private String slat = "salt";
	private String second_algorithmName = "MD5";

	
    /**
     * 
     * @param origin	���ܵ��ַ���
     * @param key ��
     * @param algorithmName	�㷨��
     * @param hashIterations ���ܴΔ�
     * @return
     */
	  
	  
    public String encryptPassword(String origin,String salt) {
    	DefaultHashService hashService = new DefaultHashService(); //Ĭ���㷨SHA-512
    	hashService.setHashAlgorithmName("SHA-512");
    	hashService.setPrivateSalt(new SimpleByteSource("salt")); //˽�Σ�Ĭ����
		/*
		 * hashService.setGeneratePublicSalt(true);//�Ƿ����ɹ��Σ�Ĭ��false
		 * hashService.setRandomNumberGenerator(new
		 * SecureRandomNumberGenerator());//�������ɹ��Ρ�Ĭ�Ͼ����
		 */    	
    	 hashService.setHashIterations(2); //����Hashֵ�ĵ�������
		 HashRequest request = new HashRequest.Builder()
    	            .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes(origin))
    	            .setSalt(ByteSource.Util.bytes(salt)).setIterations(2).build();
         String hex = hashService.computeHash(request).toHex();
		/*
		 * String hex = hashService.computeHash(request).toHex(); String encryValue =
		 * new SimpleHash( algorithmName, origin, ByteSource.Util.bytes(key),
		 * hashIterations).toHex();
		 */
    	return hex;
    }
    
    
	
}
