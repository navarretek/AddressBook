package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.address;

/**
 * Servlet implementation class addAddressServlet
 */
@WebServlet("/addAddressServlet")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String street = request.getParameter("street");
			int houseNumber = Integer.parseInt(request.getParameter("houseNumber"));
			String country = request.getParameter("country");
			String city = request.getParameter("city");

			address c = new address(street, houseNumber, country, city);
			AddressHelper ah = new AddressHelper();
			ah.insertAddress(c);
			
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResidentHelper dao = new ResidentHelper();
		req.setAttribute("allResidents", dao.showAllResidents());
		if (dao.showAllResidents().isEmpty()) {
			req.setAttribute("allResidents", " ");
		}
	}

}
