package ca.immigrants.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
			
			
			// TODO Auto-generated method stub
			PrintWriter out=response.getWriter();
		    String viewpage="ErrorView.jsp";
		    RequestDispatcher rd;
		    AgeBean monAge = new AgeBean();
		
			if(monAge.connectToDB()){
			//response.getWriter().append("Served at: ").append(request.getContextPath());
				try{
					int minAge=Integer.parseInt(request.getParameter("minAge"));
					int maxAge=Integer.parseInt(request.getParameter("maxAge"));
					int pointsAge=Integer.parseInt(request.getParameter("pointsAge"));
					
					monAge.setMaxAge(maxAge);
					monAge.setMinAge(minAge);
					monAge.setPointsAge(pointsAge);
					monAge.savePersonneInfo();
				
					request.setAttribute("model", monAge);
					//viewpage="ListePersonnes.jsp";
					viewpage="saisirAdministration.jsp";
					
				}catch(Exception e){
					//ignorer l'exception
				}
				
			}
			
				rd = request.getRequestDispatcher(viewpage);
				rd.forward(request, response);	
			
			
			
	//
//			AgeBean age = new AgeBean();
//			Integer maximum = (Integer)Integer.parseInt(request.getParameter("maxAge"));
//			Integer minimum = (Integer)Integer.parseInt(request.getParameter("minAge"));
//			Integer points = (Integer)Integer.parseInt(request.getParameter("pointsAge"));
	//
//			
	//
//			if (maximum != null && maximum != null && maximum != null){
//				age.setMaxAge(maximum);
//				age.setMinAge(minimum);
//				age.setPointsAge(points);
//				age.ChangerPoints();
//				request.setAttribute("age", age);
//				getServletContext().getRequestDispatcher("/PageAcceuil.jsp").forward(request, response);
//			}else{
//				getServletContext().getRequestDispatcher("/AcceuilAdministration.jsp").forward(request, response);}
	//
//		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
