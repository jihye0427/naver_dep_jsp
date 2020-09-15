package action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.BoardDAO;
import dao.DAOManager;
import dto.BoardDTO;
import dto.Reply;

public class AddReplyAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		request.setCharacterEncoding("utf-8");
		String board_no=request.getParameter("board_no");
		String content=request.getParameter("content");
		String writer=request.getParameter("writer");
		
		Reply reply= new Reply(Integer.parseInt(board_no), content, writer);
		DAOManager.getBoardDAO().addReply(reply);
		
		
		
		return null;
	}

}
