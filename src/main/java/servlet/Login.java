package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaskDAO;
import dao.UserDAO;
import model.Task;
import model.User;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User loginUser = new User(request.getParameter("id"),request.getParameter("pass"));
		UserDAO uDao = new UserDAO();
		TaskDAO tDao = new TaskDAO();
		ArrayList <Task> TaskList = new ArrayList<>();
		//ログイン出来たら画面遷移
		if (uDao.Login(loginUser)) {
			//sessionでログイン情報を保持
			session.setAttribute("loginUserId", loginUser.getId());
			TaskList = (ArrayList<Task>) tDao.FindTask(loginUser.getId());
			session.setAttribute("TaskList", TaskList);
			//メイン画面にフォワード
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/main.jsp");
			rd.forward(request, response);			
		}

	}
}





/*
 * idは連番にしてもよかった
 * 入力処理はバリデーション必要
 * 今回だけ変数を使わず直接代入など横着
 * アクションタグEL式 DTO Entity JSTLなどを次は使用する
 * delflgではなくcompflg
 * Taskクラスにコンストラクタ作りすぎ
*/
