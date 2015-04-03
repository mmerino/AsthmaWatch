package asthma.watch;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/asthmawatch")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String zip = request.getParameter("zip");
		if (zip == null || zip.isEmpty() || zip.length() < 5) {
			errorOuput(request, response);
		} else {
			try {
				AsthmaWatch aw = new AsthmaWatch(request, response, zip);
				aw.setPollenInfo();
				aw.setWeatherInfo();
				// aw.setForecastInfo();
				// aw.setAstronomyInfo();
				// aw.setPollutionInfo();
				aw.goToResults();
			} catch (Exception e) {
				request.setAttribute("message",
						"There was an error: " + e.getMessage());
				errorOuput(request, response);
			}
		}

	}

	// validate the parameters
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	private void errorOuput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = (String) request.getAttribute("message");
		if (message == null) {
			message = "Please fill in the zip code.";
		}

		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/enter_zip.jsp").forward(
				request, response);
	}
}