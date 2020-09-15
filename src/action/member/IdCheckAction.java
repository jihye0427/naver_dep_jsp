package action.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.DAOManager;

public class IdCheckAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		//System.out.println("ajax data :"+ id);
		//DB처리
		int result=DAOManager.getMemberDAO().idCheck(id);
		//존재하지않으면 0, 존재하면 1
		System.out.println(result);
		PrintWriter out=response.getWriter();
		out.print(result);
		out.flush();
		return null;
	}

}
