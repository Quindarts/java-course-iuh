package shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shopping.dao.ProductDAO;
import shopping.daoImpl.ProductDAOImp;
import shopping.entities.ItemCart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cart","/cart*"})
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
			actionCode = 0; // khi action là "buy"
		} else if (action.equals("remove")) {
			actionCode = 1; // khi action là "remove"
		} else {
			actionCode = -1; // Mặc định nếu action không khớp với các trường hợp đã xác định
		}
		switch (actionCode) {
		case 0:
			this.doGetBuy(request, response);
			break;
		case 1:
			this.doGetRemove(request, response);
			break;
		default:
			this.doGetDisplayCart(request, response);
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		List<ItemCart> cart = (List) session.getAttribute("cart");
		int index = this.isProductExisting(Integer.parseInt(request.getParameter("id")), cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart");
	}

	// [ GET ORDER]
	private void doGetBuy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<ItemCart> cart = null;
		if (session.getAttribute("cart") == null) {
			cart = new ArrayList();
		} else {
			cart = (List<ItemCart>) session.getAttribute("cart");
		}

		int index = this.isProductExisting(Integer.parseInt(request.getParameter("id")), (List) cart);
		if (index == -1) {
			ProductDAO productDAO = new ProductDAOImp();

			int productID = Integer.parseInt(request.getParameter("id"));
			ItemCart item = null;
			try {
				item = new ItemCart(productDAO.getById(productID), 1);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			((List<ItemCart>) cart).add(item);
		} else {
			int quantity = ((ItemCart) ((List) cart).get(index)).getQuantity() + 1;
			((ItemCart) ((List) cart).get(index)).setQuantity(quantity);
		}

		session.setAttribute("cart", cart);
		response.sendRedirect("cart");
	}

	// [HELPER]
	private int isProductExisting(int id, List<ItemCart> cart) {
		for (int i = 0; i < cart.size(); ++i) {
			if (((ItemCart) cart.get(i)).getProduct().getId() == id) {
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
