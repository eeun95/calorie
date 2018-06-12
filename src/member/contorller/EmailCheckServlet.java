package member.contorller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






/**
 * Servlet implementation class EmailCheckServlet
 */
@WebServlet("/emailAuth")
public class EmailCheckServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public EmailCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    

    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String email = request.getParameter("email");
          System.out.println(email);
          String authNum="";
          
          StringBuffer buffer = new StringBuffer();
          for(int i=0;i<=6;i++) {
             int n = (int)(Math.random()*10);
             buffer.append(n);
          }
          
          
          authNum= buffer.toString();

          sendEmail(email.toString(),authNum);
          
          request.setAttribute("email", email);
          request.setAttribute("authNum", authNum);
          RequestDispatcher rd=request.getRequestDispatcher("/views/common/emailAuth.jsp");
          rd.forward(request, response);
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }
   
   
   private void sendEmail(String email,String authNum) {
      String host="smtp.gmail.com";
      String subject="#Calorie 인증번호 전달";
      String fromName="#Calorie 관리자";
      String from="#Calorie";
      String to1=email;
      
      String content="인증번호["+authNum+"]";
      
      try {
         Properties props= new Properties();
         
         props.put("mail.smtp.starttls.enable","true");
         props.put("mail.transport.protocol", "smtp");
         props.put("mail.smtp.host", host);
         props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         props.put("mail.smtp.port", "465");
         props.put("mail.smtp.user", from);
         props.put("mail.smtp.auth", "true");
         
         Session mailSession=Session.getInstance(props,
               new javax.mail.Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
                     return new PasswordAuthentication("ppj1017@gmail.com", "ahfmrqhd1!a");
                  }
         });
         Message msg= new MimeMessage(mailSession);
         msg.setFrom(new InternetAddress(from,MimeUtility.encodeText(fromName,"UTF-8","B")));
         InternetAddress[] address1= {new InternetAddress(to1)};
         
         msg.setRecipients(Message.RecipientType.TO, address1);
         msg.setSubject(subject);
         msg.setSentDate(new java.util.Date());
         msg.setContent(content,"text/html;charset=euc-kr");
         
         Transport.send(msg);
   
      }catch(MessagingException e) {
         e.printStackTrace();
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
}