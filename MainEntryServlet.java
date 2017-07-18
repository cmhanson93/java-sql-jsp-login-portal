package logindb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainEntryServlet
 */
//@WebServlet("/MainEntryServlet")
public class MainEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		int counter = 0;
		PrintWriter out = response.getWriter();
		out.println( username + "!<br>");
		counter = 0;
		HttpSession session = request.getSession(true);
		session.setAttribute("user", username);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); // use this one
			ItemDBEntry table = new ItemDBEntry();
		
			table.createTable();
			
			double p1 = Double.parseDouble(request.getParameter("price1"));
			double p2 = Double.parseDouble(request.getParameter("price2"));
			double p3 = Double.parseDouble(request.getParameter("price3"));
			double p4 = Double.parseDouble(request.getParameter("price4"));
			double p5 = Double.parseDouble(request.getParameter("price5"));
		
			//List for holding books
			ArrayList<Item> items = new ArrayList<Item>();
			//add books to list
			items.add(new Item(1,request.getParameter("type1"),request.getParameter("title1"),p1));
			items.add(new Item(2,request.getParameter("type2"),request.getParameter("title2"),p2));
			items.add(new Item(3,request.getParameter("type3"),request.getParameter("title3"),p3));
			items.add(new Item(4,request.getParameter("type4"),request.getParameter("title4"),p4));
			items.add(new Item(5,request.getParameter("type5"),request.getParameter("title5"),p5));
			
			table.insertItems(items);//add books to table
			
			items.clear();//remove books from list
			
	}

}
