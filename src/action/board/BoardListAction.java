package action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;

import action.Action;
import dao.BoardDAO;
import dao.DAOManager;
import dto.BoardDTO;
import vo.PageInfo;

public class BoardListAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("BoardListAction가 실행됩니다.");
		 
	 	int pageNo=1;
		String r_pageNo=request.getParameter("pageNo");
		if(r_pageNo!=null) {
			pageNo=Integer.parseInt(r_pageNo);
		}
		//DB처리-DAO
		//DB접속
		BoardDAO dao=DAOManager.getBoardDAO();
		System.out.println("dao : "+dao);
		//페이지정보 세팅
		
		int limit=10;
		int offset=(pageNo-1)*limit;
		RowBounds rowBounds=new RowBounds(offset, limit);
		List<BoardDTO> list=dao.boardList(rowBounds);
		
		request.setAttribute("boardList", list);
		return "/WEB-INF/view/board/boardList.jsp";
	}

}
