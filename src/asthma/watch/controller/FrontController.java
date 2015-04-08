package asthma.watch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asthma.watch.model.WeatherData;
import asthma.watch.service.BusinessDelegate;

@WebServlet("/asthmawatch")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String zip = request.getParameter("zip");
		String type = request.getParameter("type");
		String[] weatherTypes = { "pollen", "conditions", "pollution",
				"forecast" };
		if (zip == null || zip.isEmpty() || zip.length() < 5) {
			errorOuput(request, response);
		}
		try {
			BusinessDelegate apiDelegate = new BusinessDelegate(zip);
			for (String weatherType : weatherTypes) {
				WeatherData weatherData = apiDelegate.fetchWeatherData(weatherType);
				request.setAttribute(weatherType, weatherData);
			}
		} catch (Exception e) {
			request.setAttribute("message",
					"There was an error: " + e.getMessage());
			errorOuput(request, response);
		}

		dispatchResults(type, request, response);
	}

	/**
	 * Determines the page to show the user based on the type query parameter and sends
	 * it through the servlet dispatcher. Defaults to AsthmaResults on invalid/empty value.
	 * 
	 * @param type Either "asthma", "stargazing", or "cycling"
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void dispatchResults(String type, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (type.equals("stargazing")) {
			dispatchStargazingResults(request, response);
		} else if (type.equals("cycling")) {
			dispatchCyclingResults(request, response);
		} else {
			dispatchAsthmaResults(request, response);
		}
	}
	
	protected void dispatchAsthmaResults(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("AsthmaResults.jsp").forward(request, response);
	}
	
	protected void dispatchCyclingResults(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO: no cycling results page
		request.getRequestDispatcher("CyclingResults.jsp").forward(request, response);
	}
	
	protected void dispatchStargazingResults(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO: this page is just a placeholder right now
		request.getRequestDispatcher("StargazingResults.jsp").forward(request, response);
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