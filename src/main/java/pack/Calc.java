package pack;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name="Calc", urlPatterns="/Calc")
public class Calc extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		
		request.getRequestDispatcher("/Result.jsp").forward(request, response);
				 
		
	}
	
	private static class RequestCalc {
		private final String first_calc;
		private final String second_calc;
		private final String third_calc;
		private double result;
		
		private RequestCalc (String first, String second, String third) {
			this.first_calc = first;
			this.second_calc = second;
			this.third_calc = third;
		}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("first"),
			request.getParameter("second"),
			request.getParameter("third"));
			}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("first_result", first_calc);
			request.setAttribute("second_result", second_calc);
			request.setAttribute("third_result", third_calc);
			int first_try;
			int second_try;
			int third_try;
			try {
				first_try = Integer.parseInt(first_calc);
				second_try = Integer.parseInt(second_calc);
				third_try = Integer.parseInt(third_calc);
			}
			catch (NumberFormatException e) {
				first_try = 0;
				second_try = 0;
				third_try = 0;
			}
			result = (first_try + second_try) * 0.5 * third_try;
			request.setAttribute("result", result);
			
			
		}
	}
}
