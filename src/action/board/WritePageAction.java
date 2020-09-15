package action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class WritePageAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		//세션이 유지되어있는지 체크...
		
			//세션이 유지 되어있지 않으면 로그인페이지도 이동
				
		//DB처리
		
		String path="/WEB-INF/view/board/write.jsp";
		return path;
	}

}
