package asthma.watch;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.data.UserDB;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL claritinUrl = new URL(Constants.CLARITIN_URL + "48145");
		URL weatherUrl = new URL(Constants.WU_URL + "conditions/q/" + "48145.json");
		new AsthmaWatch(request, response, claritinUrl, weatherUrl);
	}
	// validate the parameters
    String message;
    if (zipCode == null|| zipCode.isEmpty() {
        message = "Please enter a valid zip code.";
        url = "/enter_zip.jsp";
    } 
    else {
        message = null;
        url = "/thanks.jsp";
        UserDB.insert(user);
    }
    request.setAttribute("user", user);
    request.setAttribute("message", message);
    request.setAttribute("currentYear", currentYear);
    
}
}
