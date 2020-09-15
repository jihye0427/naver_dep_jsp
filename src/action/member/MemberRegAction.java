package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.DAOManager;
import dao.MemberDAO;
import dto.Member;
import sha256.ShaUtil;

public class MemberRegAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		//고급로직
		String id=request.getParameter("id");
		String _pw=request.getParameter("pw");
		String pw=ShaUtil.getSHA256(_pw);//암호화
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		//DB처리
		
		Member member=new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setEmail(email);
		
		MemberDAO dao=DAOManager.getMemberDAO();
		
		dao.addMember(member);
		
		request.setAttribute("info", name+"님! 회원가입을 축하합니다.<br>로그인후 이용하세요!");
		String path="/WEB-INF/view/member/login.jsp";
		return path;
	}

}
