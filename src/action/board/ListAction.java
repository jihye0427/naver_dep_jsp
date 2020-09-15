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

public class ListAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		//디비에 접속해서 게시판 정보 갖고오기
		//최초 접속시 pageNo=1
		
		String path="/WEB-INF/view/board/list.jsp";
		return path;
	}

}
