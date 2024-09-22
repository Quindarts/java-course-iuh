package shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shopping.dao.ProductDAO;
import shopping.daoImpl.ProductDAOImp;
import shopping.entities.Product;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO product_DAO = new ProductDAOImp();

		// init products
		try {
			List<Product> productsDB = product_DAO.findAll();
			if (productsDB.size() < 1) {
				Product p1 = new Product("Product 1", 50000, "image1.png");
				product_DAO.addProduct(p1);
				Product p2 = new Product("Product 2", 20000, "image2.png");
				product_DAO.addProduct(p2);
				Product p3 = new Product("Product 3", 40000, "image3.jpeg");
				product_DAO.addProduct(p3);
				Product p4 = new Product("Product 4", 80000, "image4.jpeg");
				product_DAO.addProduct(p4);
				Product p5 = new Product("Product 5", 100000, "image5.png");
				product_DAO.addProduct(p5);
				List<Product> productsDB2 = product_DAO.findAll();
				request.setAttribute("products", productsDB2);
			} else
				request.setAttribute("products", productsDB);

		} catch (Throwable e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Product.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
