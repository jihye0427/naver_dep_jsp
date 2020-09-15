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

public class BoardAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		//디비에 접속해서 게시판 정보 갖고오기
		//최초 접속시 pageNo=1
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
		
		int limit=5;
		int offset=(pageNo-1)*limit;
		RowBounds rowBounds=new RowBounds(offset, limit);
		List<BoardDTO> list=dao.boardList(rowBounds);
		
		//전제페이지수
		int rowTotal=dao.boardTotal();
		PageInfo pageInfo=new PageInfo(pageNo,rowTotal, limit);
		
		//페이지이동정보
		request.setAttribute("list", list);
		request.setAttribute("pageInfo", pageInfo);
		String path="/WEB-INF/view/board/board.jsp";
		return path;
	}

}
