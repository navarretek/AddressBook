package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Resident;
import Model.address;

/**
 * Servlet implementation class AddResidentServlet
 */
@WebServlet("/AddResidentServlet")
public class AddResidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResidentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		LocalDate dob = LocalDate.parse((request.getParameter("dateOfBirth")));

		Resident c = new Resident(name, dob);
		ResidentHelper rh = new ResidentHelper();
		rh.insertResident(c);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
