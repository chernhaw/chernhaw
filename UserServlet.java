

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import ch.data.DBTest;
import ch.data.User;
import ch.data.UserDB;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
		String email = request.getParameter("email");
		
		String action = request.getParameter("action");
		
		System.out.println("email : "+email + " action : "+action);
		System.out.println("Email received "+ email);
		User user = UserDB.getUserByEmail(email);
		
		HttpSession session = request.getSession();
		
		String url = "/index.jsp";
		if (user !=null & action=="add") {
			System.out.println(user.toString());
			
			
			session.setAttribute("user", user);
			url = "/user.jsp";
			
		} else if (user !=null & action.equals("update")) {
			
			session.setAttribute("user", user);
			
			url = "/updateUserDetails.jsp";
			
		} 
		System.out.println("Forwarded URL " + url);
		
		sc.getRequestDispatcher(url).forward(request, response);
//			ps.setInt(1,  random_int);
//			ps.setString(2,  User.getEmail());
//			ps.setString(3,  User.getFirstname());
//			ps.setString(4,  User.getLastname());
//			ps.setDate(5, sqlDate);
		
	//	DBTest dbTest = new DBTest();
		
	//	dbTest.init();
		
		
	//	User user = new User();
		
//		user.setFirstname("Tong");
//		user.setLastname("Ham3");
//		user.setEmail("hamm2@mail.com" );
	//	System.out.println("Preparing new user detail at servlet "+user.toString());
		//UserDB.insert(user);
		
		
	//	User user=UserDB.getUserById(11);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		// TODO Auto-generated method stub
		if (action.equals("add")) {
			
			
		
			System.out.println("add new user");
			//UserDB.updatebyId(user, 11);
			System.out.println(email);
			System.out.println(firstName);
			System.out.println(lastName);
			
			UserDB.insert(email, firstName, lastName);
		} else if (action.equals("Update User")) {
			
			System.out.println("update current user");
			System.out.println(email);
			System.out.println(firstName);
			System.out.println(lastName);
			
			System.out.print("To implement update");
			
		}
		
		
		
	}

}
