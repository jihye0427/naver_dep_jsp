package action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.DAOManager;
import dto.Reply;
import vo.SortInfo;

public class GetReplyAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		request.setCharacterEncoding("utf-8");
		String _board_no=request.getParameter("board_no");
		int board_no=Integer.parseInt(_board_no);
		
		String sort=request.getParameter("sort");
		
		SortInfo sortInfo=new SortInfo();
		sortInfo.setBoard_no(board_no);
		sortInfo.setSort(sort);
		
		List<Reply> list=DAOManager.getBoardDAO().getReply(sortInfo);
		
		request.setAttribute("replyList", list);
		
		return "/WEB-INF/view/board/replyList.jsp";
	}

}
