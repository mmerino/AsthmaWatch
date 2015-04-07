package asthma.watch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asthma.watch.model.WeatherData;
import asthma.watch.service.AsthmaWatch;

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
		String[] weatherTypes = { "pollen", "conditions", "pollution",
				"forecast" };
		if (zip == null || zip.isEmpty() || zip.length() < 5)
			errorOuput(request, response);
		try {
			AsthmaWatch aw = new AsthmaWatch(zip);
			for (String weatherType : weatherTypes) {
				WeatherData weatherData = aw.fetchWeatherData(weatherType);
				request.setAttribute(weatherType, weatherData);
			}
		} catch (Exception e) {
			request.setAttribute("message",
					"There was an error: " + e.getMessage());
			errorOuput(request, response);
		}
		AsthmaResults(request, response);
	}

	protected void AsthmaResults(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("AsthmaResults.jsp").forward(request,
				response);
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