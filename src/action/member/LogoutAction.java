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

public class LogoutAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		//session에서 logInfo 제거
		request.getSession().removeAttribute("logInfo");
		
		response.sendRedirect("index.jsp");
		return null;
	}

}
