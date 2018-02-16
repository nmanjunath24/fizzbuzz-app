package com.fizzbuzz.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FizzBuzzServlet
 */
@WebServlet("/FizzBuzzServlet")
public class FizzBuzzServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String COMMA_STRING = ", ";
	private static final String regex = "[0-9]+(,[0-9]+)*";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FizzBuzzServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String input = request.getParameter("userInput");
		// validate and allow only if user input contains number or numbers
		// separated by commas
		if (input.matches(regex)) {
			String[] strArray = input.split(",");

			StringBuffer result = new StringBuffer();
			for (int i = 0; i < strArray.length; i++) {
				Long j = Long.valueOf(strArray[i].trim());
				if (j % 3 == 0) {
					if (j % 5 == 0) {
						// Number divisible by both 3 and 5
						result.append("fizz buzz");
					} else {
						// Number divisible by 3
						result.append("fizz");
					}
				} else if (j % 5 == 0) {
					// Number divisible by 3
					result.append("buzz");
				} else {
					// Number not divisible by 3 or 5
					result.append(j);
				}
				if (i < strArray.length - 1) {
					result.append(COMMA_STRING);
				}
			}
			// setting the result
			request.setAttribute("result", String.valueOf(result));
		} else {
			// setting error message when user enter any other characters other
			// than numbers or comma
			request.setAttribute("error", "Please enter valid number(s).");
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

}
