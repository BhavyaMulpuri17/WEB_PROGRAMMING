import java.util.Calendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail 
{
	public static boolean sendMail(String target) 
	{
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", false);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,null);
		session.setDebug(true);

		System.out.println("send mail  ");
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bhavyamulpuri6@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(target));
			message.setSubject("MSIT Admission "+year+" Account Activation");
			message.setContent("hello","text/html");
			//<html><head></head><body bgcolor=\"##eee\"><div style=\"width: 35.4%;height:200px;margin: 10px auto;background-color: white;padding: 10px 30px;\"><h1 style=\"background-color:#337ab7\" >Thank you for signing up!</h1><p style=\"font-weight: bold;\">We are excited to have you join us in MSIT</p><p>Please activate your account to continue</p><hr style=\"font-weight: bold; color: #eee;\"><a href=\"http://localhost:8081/BookUrSlot/users/setPswd?email="+target+"\"><input type=\"submit\" value=\"Activate\" style=\"color: white;font-weight: bolder;font-size:20px;background-color:#337ab7;position: absolute;margin-left: 150px;padding: 0px 15px;text-align: center;cursor: pointer;\"></a></div></body></html>
			Transport t = session.getTransport("smtp");
			t.connect("smtp.gmail.com","bhavyamulpuri6","Bhavya171995");
			t.sendMessage(message, message.getAllRecipients());
			System.out.println("Done");
			return true;
		} 
		catch (MessagingException e) 
		{
			return false;
		}
	}
	
	public static void main(String[] args) 
	{
		sendMail("aparna9795@gmail.com");
	}

}
