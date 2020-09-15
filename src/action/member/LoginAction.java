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

public class LoginAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		Login log=new Login();
		log.setId(id);
		log.setPw(ShaUtil.getSHA256(pw));//pw암호화 
		//DB처리
		Member member=DAOManager.getMemberDAO().login(log);
		//id,pw 일치하면 member정보 갖고오고
		//일치하지 않으면 null
		System.out.println(member);
		String path=null;
		if(member!=null) {
			//일치하면
			//session을이용하여 로그인 정보확인
			HttpSession session=request.getSession();
			//session.setMaxInactiveInterval(10);
			session.setAttribute("logInfo", member);
			path="index.jsp";
		}else {
			//일치하지 않으면
			request.setAttribute("msg", "잘못된 회원정보입니다.");
			path="/WEB-INF/view/member/login.jsp";
		}
		
		return path;
	}

}
