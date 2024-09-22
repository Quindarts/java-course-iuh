package fit.se.iuh.Hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationForm() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String filePath = getServletContext().getRealPath("/Register.html");
		String content = new String(Files.readAllBytes(Paths.get(filePath)));
		out.print(content);

		String userName = request.getParameter("userName");
		String f_name = request.getParameter("firstName");
		String l_name = request.getParameter("lastName");

		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		String fb = request.getParameter("fb");
		String shortTXT = request.getParameter("short");
		System.out.println(userName);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String fb = request.getParameter("fb");
		String shortBio = request.getParameter("short");
		
		//log
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Username: " + userName);
		System.out.println("Email: " + email);
		System.out.println("Password: " + pwd);
		System.out.println("Facebook: " + fb);
		System.out.println("Short Bio: " + shortBio);
	    response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Registration Result</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<script type='text/javascript'>");
        response.getWriter().println("alert('Xin chào bạn, đăng ký thành công -> Login page');");
        response.getWriter().println("window.location.href = 'Login.html';"); 
        response.getWriter().println("</script>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
		doGet(request, response);
	}

}
