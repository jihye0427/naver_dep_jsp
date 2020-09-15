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

public class IncRecommendAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		request.setCharacterEncoding("utf-8");
		int no=Integer.parseInt(request.getParameter("no"));
		
		DAOManager.getBoardDAO().incRecommend(no);
		
		
		return null;
	}

}
