package fit.se.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Bai7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 4096;
	private static final String SAVE_DIR = "images";

	public Bai7() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String filePath = getServletContext().getRealPath("/Bai7.html");
		String content = new String(Files.readAllBytes(Paths.get(filePath)));
		out.print(content);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		System.out.println("First Name: " + firstName);
		
		System.out.println("Last Name: " + lastName);

		InputStream inputStream = null;
		Part filePart = request.getPart("photo");
		String fileUploadName = "";
		String filePath = "D:/";

		if (filePart != null && filePart.getSize() > 0) {
			fileUploadName = filePart.getSubmittedFileName();
			inputStream = filePart.getInputStream();
			filePath += fileUploadName;
		}
		System.out.println(filePath);
		String message = null;
		Connection conn = null;
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=UploadFileServletDB;trustServerCertificate=true;encrypt=true";
			DriverManager.registerDriver(new SQLServerDriver());
			conn = DriverManager.getConnection(url, "sa", "sapassword");

			String sql = "INSERT INTO contacts (first_name, last_name, photo) values(?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);

			if (inputStream != null) {
				statement.setBlob(3, inputStream);
			} 
			else {
				statement.setNull(3, java.sql.Types.BLOB);
			}

			if (statement.executeUpdate() > 0) {
				message = "File uploaded and saved into database";
			}

			String sql1 = "SELECT photo FROM contacts WHERE first_name=? AND last_name=?";
			statement = conn.prepareStatement(sql1);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				Blob blob = result.getBlob("photo");
				inputStream = blob.getBinaryStream();
				OutputStream outputStream = new FileOutputStream(filePath);
				int bytesRead = -1;
				byte[] buffer = new byte[BUFFER_SIZE];
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				inputStream.close();
				outputStream.close();
			}
		} catch (Exception e) {
			message = "ERROR: " + e.getMessage();
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

		request.setAttribute("Message", message);
		doGet(request, response);
	}

}
