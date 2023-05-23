package kr.go.yeosu.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.QnaDTO;
import kr.go.yeosu.model.QnaDAO;


@WebServlet("/AddReply.do")
public class AddReplyCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String qno = request.getParameter("parno");
		
		QnaDAO dao = new QnaDAO();
		QnaDTO qna = dao.getQna2(qno);
		
		String msg = "답변을 시작합니다.";
		request.setAttribute("msg", msg);
		request.setAttribute("qna", qna);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/qna/addReply.jsp");
		view.forward(request, response);
	}

}
