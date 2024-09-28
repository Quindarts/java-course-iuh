package fit.se.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Bai8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Bai8() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String to = "abcd@gmail.com";
		String from = "web@gmail.com";
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		try {

			MimeMessage message = new MimeMessage(session); // Tạo đối tượng mặc định MimeMessage.
			message.setFrom(new InternetAddress(from));
			message.setSubject("Subject Line!");

			String filename = "file.txt";

		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
