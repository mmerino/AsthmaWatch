package asthma.watch;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String zip = request.getParameter("zip");
		AsthmaWatch aw = new AsthmaWatch(request, response, zip);
		aw.setPollenInfo();
//		aw.setWeatherInfo();
//		aw.setAstronomyInfo();
		aw.goToResults();
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
