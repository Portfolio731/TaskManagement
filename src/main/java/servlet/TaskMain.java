package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaskDAO;
import model.Task;

/**
 * Servlet implementation class TaskMain
 */
@WebServlet("/TaskMain")
public class TaskMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskMain() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("loginUserId");
        String task = request.getParameter("task");
        String priority = request.getParameter("priority");
        //文字列をSQLのDate型に変更
        Date limit = Date.valueOf(request.getParameter("limit")) ;
        
        //DBにタスクの追加
        Task inputTask =new Task(userId,task,priority,limit);
        TaskDAO tDao = new TaskDAO();
        tDao.AddTask(inputTask);
        
        ArrayList<Task> taskList =  (ArrayList<Task>) tDao.FindTask(userId);
       
        //セッションスコープに保存
        session.setAttribute("TaskList", taskList);
		
		//メイン画面にリダイレクト
		response.sendRedirect(request.getContextPath() + "/jsp/main.jsp");
	}

}
