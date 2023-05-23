package kr.go.yeosu.controller.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.yeosu.dto.QnaDTO;
import kr.go.yeosu.model.QnaDAO;


@WebServlet("/QnaList.do")
public class GetQnaListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String qno = request.getParameter("qno");
		
		QnaDAO dao = new QnaDAO();
		ArrayList<QnaDTO> qnaList = new ArrayList<QnaDTO>();
		QnaDTO qn = new QnaDTO();
		
		qn = dao.getQna2(qno);
		qnaList = dao.getReplyList(qno);
		
		request.setAttribute("qn", qn);
		request.setAttribute("qnaList", qnaList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/qna/qnaList.jsp");
		view.forward(request, response);
	}
}