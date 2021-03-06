package managedBean;

import java.io.IOException;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@ManagedBean(name = "mailBean")
@SessionScoped
public class MailBean {

	private String subject;
	private String text;
	private String destinataire;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public static void doSendMailDynamic(String subject, String text,
			String destinataire) throws IOException {
		
		Properties props = System.getProperties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true"); // ********
		props.put("mail.smtp.host", "smtp.gmail.com"); // serveur
		props.put("mail.smtp.port", "587"); 
		Session session = Session.getInstance(props);

		new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("salmapdev@gmail.com",
						"salmapdevweb");
			}
		};

		MimeMessage message = new MimeMessage(session);
		try {
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(text);
			MimeMultipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);

			message.setContent(mp);
			System.out.printf(destinataire);
			message.setSubject(subject);
			message.addRecipients(Message.RecipientType.TO, destinataire);
			message.addRecipients(Message.RecipientType.CC,
					"salmapdev@gmail.com");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		Transport transport = null;
		try {
			transport = session.getTransport("smtp");
			transport.connect("salmapdev@gmail.com", "salmapdevweb");
			System.out.println("tttttttttttttttttttttttttt");
			transport.sendMessage(message, new Address[] { new InternetAddress(
					destinataire) });
			System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvv");
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
			try {
				if (transport != null) {
					transport.close();
				}
			} catch (MessagingException e) {
				e.printStackTrace();
			}

		}
	}

}
