package com.tibame.tga105.mem.model;

import java.util.Properties;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
	// 設定傳送郵件:至收信人的Email信箱,Email主旨,Email內容
		public void sendMail(String to, String subject, String messageText) {
				
		   try {
			   // 設定使用SSL連線至 Gmail smtp Server
			   Properties props = new Properties();
			   props.put("mail.smtp.host", "smtp.gmail.com");
			   props.put("mail.smtp.socketFactory.port", "465");
			   props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			   props.put("mail.smtp.auth", "true");
			   props.put("mail.smtp.port", "465");

		     final String myGmail = "tree74859@gmail.com";
		     final String myGmail_password = "vftqbancavjigdyn";
		     
		     
			   Session session = Session.getInstance(props, new Authenticator() {
				   protected PasswordAuthentication getPasswordAuthentication() {
					   return new PasswordAuthentication(myGmail, myGmail_password);
				   }
			   });

			   Message message = new MimeMessage(session);
			   message.setFrom(new InternetAddress(myGmail));
			   message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			  
			   //設定信中的主旨  
			   message.setSubject(subject);
			   subject = "重設密碼通知";
			   //設定信中的內容 
			   message.setText(messageText);
			   messageText = "tttttttttttttt";

			   Transport.send(message);
			   System.out.println("傳送成功!");
	     }catch (MessagingException e){
		     System.out.println("傳送失敗!");
		     e.printStackTrace();
	     }
		   
	   }
		
//		
//		 public static void main (String args[]){
//
//	      String to = "tree748596@gmail.com";
//	      
//	      String subject = "重設密碼通知";
//	      
//	      String ch_name = "親愛的會員";
//	      
//	      String url = "request.getContextPath()/pages/member/memResetPsd03.jsp";
//	      
//	      String messageText = "您好! " + ch_name + " 請點選此連結重設您的密碼: " + url ; 
//	       
//	      MailService mailService = new MailService();
//	      mailService.sendMail(to, subject, messageText);
//	      
//	      
//	      
//	   }
}
