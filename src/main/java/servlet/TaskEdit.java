package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaskDAO;
import model.Task;

/**
 * Servlet implementation class TaskEdit
 */
@WebServlet("/TaskEdit")
public class TaskEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
        String task = request.getParameter("task");
        String priority = request.getParameter("priority");
        Date limit = Date.valueOf(request.getParameter("limit")) ;
        int taskId = Integer.parseInt(request.getParameter("taskId")) ;
        int delFlg = Integer.parseInt(request.getParameter("delFlg")) ;
        
        Task editTask = new Task(task,priority,limit,taskId,delFlg);
        //INSERT文で更新
        TaskDAO tDao = new TaskDAO();
        tDao.EditTask(editTask);
        
        String userId = (String)session.getAttribute("loginUserId");
        ArrayList<Task> taskList =  (ArrayList<Task>) tDao.FindTask(userId);
        
        //セッションスコープに保存
        session.setAttribute("TaskList", taskList);
        
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/main.jsp");
		rd.forward(request, response);	
        
	}

}
