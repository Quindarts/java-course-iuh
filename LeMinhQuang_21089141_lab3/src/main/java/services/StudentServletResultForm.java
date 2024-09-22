package services;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entity.Student;

public class StudentServletResultForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentServletResultForm() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String email = request.getParameter("email");
		String mobileNumber = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String pinCode = request.getParameter("code");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String[] hobbiesArray = request.getParameterValues("hobbies");
		String hobbies = (hobbiesArray != null) ? String.join(", ", hobbiesArray) : "";

		// Handle courses
		String[] coursesArray = request.getParameterValues("course");
		String courses = (coursesArray != null) ? String.join(", ", coursesArray) : "";

		// Qualification details
		String classXBoard = request.getParameter("classXBoard");
		String classXPercentage = request.getParameter("classXPercentage");
		String classXYear = request.getParameter("classXYear");

		String classXIIBoard = request.getParameter("classXIIBoard");
		String classXIIPercentage = request.getParameter("classXIIPercentage");
		String classXIIYear = request.getParameter("classXIIYear");
		String graduationBoard = request.getParameter("graduationBoard");
		String graduationPercentage = request.getParameter("graduationPercentage");
		String graduationYear = request.getParameter("graduationYear");

		String mastersBoard = request.getParameter("mastersBoard");
		String mastersPercentage = request.getParameter("mastersPercentage");
		String mastersYear = request.getParameter("mastersYear");

		// Create a Student object to hold the data
		Student student = new Student();
		student.setFname(fName);
		student.setLname(lName);
		student.setDay(day);
		student.setMonth(month);
		student.setYear(year);
		student.setEmail(email);
		student.setMobileNumber(mobileNumber);
		student.setGender(gender);
		student.setAddress(address);
		student.setCity(city);
		student.setPinCode(pinCode);
		student.setState(state);
		student.setCountry(country);
		student.setHobbies(hobbies);
		student.setCourse(courses);
		student.setClassXBoard(classXBoard);
		student.setClassXPercentage(classXPercentage);
		student.setClassXYear(classXYear);
		student.setClassXIIBoard(classXIIBoard);
		student.setClassXIIPercentage(classXIIPercentage);
		student.setClassXIIYear(classXIIYear);
		student.setGraduationBoard(graduationBoard);
		student.setGraduationPercentage(graduationPercentage);
		student.setGraduationYear(graduationYear);
		student.setMastersBoard(mastersBoard);
		student.setMastersPercentage(mastersPercentage);
		student.setMastersYear(mastersYear);

		request.setAttribute("student", student);

		RequestDispatcher rd = request.getRequestDispatcher("Submit_form_bai1.jsp");
		rd.forward(request, response);
		doGet(request, response);
	}

}
