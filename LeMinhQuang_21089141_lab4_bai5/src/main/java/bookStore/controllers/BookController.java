package bookStore.controllers;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;

import bookStore.dao.BookDAO;
import bookStore.daoImp.BookDAOImp;
import bookStore.entities.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/books", "/books/*" })
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;

	public BookController() {
		super();
		bookDAO = new BookDAOImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("details")) {
			int bookId = Integer.parseInt(request.getParameter("id"));
			try {
				Book book = bookDAO.getById(bookId);
				request.setAttribute("book", book);
				request.getRequestDispatcher("BookDetails.jsp").forward(request, response);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			List<Book> books;
			try {
				books = bookDAO.findAll();
				
				request.setAttribute("books", books);
				request.getRequestDispatcher("Books.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
