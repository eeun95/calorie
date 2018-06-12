package common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class EncryptWrapper extends HttpServletRequestWrapper{  //password를 암호화해서 DB에 저장하는 작업
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	@Override
	public String getParameter(String key) {
		String value="";
		if(key!=null && ("member_pw".equals(key)||"member_pwcheck".equals(key)||"member_pw_new".equals(key))) {
			value=super.getParameter(key);
			value=getSHA512(value);
			System.out.println("암호화 :"+value);
		}
		else {
			value=super.getParameter(key);
		}
		return value;
	}
	private static String getSHA512(String password) {
		String sncPwd="";
		MessageDigest md=null;
		try {
			md=MessageDigest.getInstance("SHA-512"); //암호화를 불러옴.
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		byte[] bytes=password.getBytes(Charset.forName("UTF-8")); //password의 bytes의 인코딩 값을 UTF-8로 지정 
		md.update(bytes); //SHA-512로 암호화 작업
		sncPwd=Base64.getEncoder().encodeToString(md.digest()); //먼저 bytes값을 base64인코딩을 한후 byte값을 String 값으로 바꾸어 주는 작업
		
		return sncPwd;
		}
}
