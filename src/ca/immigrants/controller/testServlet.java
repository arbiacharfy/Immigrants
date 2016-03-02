package ca.immigrants.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.immigrants.models.AgeBean;

@WebServlet(asyncSupported = true, urlPatterns = { "/testServlet" })
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public testServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AgeBean age = new AgeBean();
		Integer maximum = (Integer)Integer.parseInt(request.getParameter("maxAge"));
		Integer minimum = (Integer)Integer.parseInt(request.getParameter("minAge"));
		Integer points = (Integer)Integer.parseInt(request.getParameter("pointsAge"));

		

		if (maximum != null && maximum != null && maximum != null){
			age.setMaxAge(maximum);
			age.setMinAge(minimum);
			age.setPointsAge(points);
			age.ChangerPoints();
			request.setAttribute("age", age);
			getServletContext().getRequestDispatcher("/PageAcceuil.jsp").forward(request, response);
		}else{
			getServletContext().getRequestDispatcher("/AcceuilAdministration.jsp").forward(request, response);}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
