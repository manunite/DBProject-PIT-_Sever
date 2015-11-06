package HKJ;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class sign_up
 */
@WebServlet("/user_list")
public class User_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		Vector<UserBean> resultVec = new Vector<UserBean>();

		loginMgr mgr = new loginMgr();
		
		resultVec = mgr.getList(); 
		
		Gson temp = new Gson();
		PrintWriter out = response.getWriter();
		
		if(resultVec != null)
		{
			System.out.println("success");
			//System.out.println(resultVec.size());
			System.out.println(temp.toJson(resultVec));
			//out.print(temp.toJson(resultVec));
			out.print("{\"status\":\"OK\",\"num_results\":\"0\",\"results\":"+temp.toJson(resultVec)+"}");
		}
		else
		{
			System.out.println("fail");
			out.print(temp.toJson(null));
		}
		
	}

}