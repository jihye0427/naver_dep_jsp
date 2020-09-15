package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import dao.DAOManager;
import dto.Login;
import dto.Member;
import sha256.ShaUtil;

public class MypageAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		//세션이 유지되어있는지 체크...
		
		//세션이 유지 되어있지 않으면 로그인페이지도 이동
		
		return "/WEB-INF/view/member/mypage.jsp";
	}

}
