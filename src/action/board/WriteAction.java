package action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.BoardDAO;
import dao.DAOManager;
import dto.BoardDTO;

public class WriteAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		request.setCharacterEncoding("utf-8");
		String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		BoardDTO board=new BoardDTO();
		board.setContent(content);
		board.setSubject(subject);
		board.setWriter(writer);
		board.setUser_ip(request.getRemoteHost());//IP
		
		
		//DB처리
		BoardDAO dao=DAOManager.getBoardDAO();
		//for(int i=1; i<=10000; i++) {
			//board.setSubject(subject+"_"+i);
			//board.setContent(content+"_"+i);
			dao.insertBoard(board);
		//}
		
		//게시판 첫페이지...이동
		//요청을 다시합니다.board.bo
		response.sendRedirect("board.bo");
		return null;
	}

}
