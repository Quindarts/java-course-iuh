package fit.se.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@MultipartConfig(location = "D:\\test", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 10)
public class Bai6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String upPath = null;
	
	public Bai6() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() throws ServletException {
		super.init();
		upPath = getServletContext().getInitParameter("upload.path");
		File uploadDir = new File(upPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String filePath = getServletContext().getRealPath("/Bai6.html");
		String content = new String(Files.readAllBytes(Paths.get(filePath)));

		out.print(content);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			for (Part filePart : request.getParts()) {
				if (filePart == null || filePart.getSubmittedFileName() == null) {
					continue;
				}
				String fileName = filePart.getSubmittedFileName();
				InputStream input = filePart.getInputStream();
				Files.copy(input, Paths.get(upPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
				System.out.println(upPath + File.separator + fileName);
			}
			response.getWriter().println("Upload Success !!!!!");

		} catch (Exception e) {
			response.getWriter().println("Failed: " + e.getMessage());
		}
		doGet(request, response);
	}

}
