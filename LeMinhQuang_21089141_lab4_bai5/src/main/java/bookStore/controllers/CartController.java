package bookStore.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bookStore.dao.BookDAO;
import bookStore.daoImp.BookDAOImp;
import bookStore.entities.OrderItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/cart" })
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		int actionCode;
		if (action == null) {
			actionCode = -1;
		} else if (action.equals("buy")) {
			actionCode = 0;
		} else if (action.equals("remove")) {
			actionCode = 1;
		} else if (action.equals("payment")) {
			actionCode = 2;
		} else
			actionCode = -1;
		switch (actionCode) {
		case -1: {
			doGetDisplayCart(request, response);
			break;
		}
		case 0: {
			doGetBuy(request, response);
			break;
		}
		case 1: {
			doGetRemove(request, response);
			break;
		}
		case 2: {
			doGetPayment(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + actionCode);
		}
	}

	// [GET CART]
	private void doGetDisplayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

	// [REMOVE ITEM]
	private void doGetRemove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<OrderItem> cart = (List) session.getAttribute("cart");
		int index = this.isProductExisting(Integer.parseInt(request.getParameter("id")), cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart");
	}

	private void doGetPayment(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		List<OrderItem> cart = null;
		if (session.getAttribute("cart") == null) {
			cart = new ArrayList<OrderItem>();
		} else
			cart = (List<OrderItem>) session.getAttribute("cart");
		res.sendRedirect("payment");
	}

	// [ GET ORDER]
	private void doGetBuy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<OrderItem> cart = null;
		if (session.getAttribute("cart") == null) {
			cart = new ArrayList();
		} else {
			cart = (List<OrderItem>) session.getAttribute("cart");
		}

		int index = this.isProductExisting(Integer.parseInt(request.getParameter("id")), (List) cart);
		if (index == -1) {
			BookDAO bookDAO = new BookDAOImp();

			int bookId = Integer.parseInt(request.getParameter("id"));
			OrderItem item = null;
			try {
				item = new OrderItem(bookDAO.getById(bookId), 1);
			} catch (Throwable e) {

				e.printStackTrace();
			}
			((List<OrderItem>) cart).add(item);
		} else {
			int quantity = ((OrderItem) ((List) cart).get(index)).getQuantity() + 1;
			((OrderItem) ((List) cart).get(index)).setQuantity(quantity);
		}

		session.setAttribute("cart", cart);
		response.sendRedirect("cart");
	}

	// [HELPER]
	private int isProductExisting(int id, List<OrderItem> cart) {
		for (int i = 0; i < cart.size(); ++i) {
			if (((OrderItem) cart.get(i)).getBook().getBookId() == id) {
				return i;
			}
		}
		return -1;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
