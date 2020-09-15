package action.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.BoardDAO;
import dao.DAOManager;
import dto.BoardDTO;

public class DeleteAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		int no=Integer.parseInt(request.getParameter("no"));
		
		//DB처리
		BoardDAO dao=DAOManager.getBoardDAO();
		System.out.println("dao : "+dao);
		//삭제메서드 실행
		dao.delete(no);
		
		//삭제후에 목록페이지로 이동
		response.sendRedirect("board.bo");
		return null;
	}

}
