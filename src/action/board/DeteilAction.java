package action.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.BoardDAO;
import dao.DAOManager;
import dto.BoardDTO;
import dto.T_File;

public class DeteilAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//고급로직
		String p_no=request.getParameter("no");
		int no=0;
		if(p_no!=null) {
			try {
				no=Integer.parseInt(p_no.trim());
			}catch (NumberFormatException e) {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter(); 
				   
				//history.go(-1) >> 이전페이지로 -2가되면  이전 이전 페이지로 
				String msg = "정상적인페이지가 아닙니다.";
				String str="";
				str = "<script language='javascript'>"; 
				str += "alert('"+ msg + "');";   //얼럿창 띄우기
				str += "history.go(-2);";    //이전페이지로 가기
				str += "</script>";
				out.print(str);
				//response.sendRedirect("board.bo");
				return null;
			}
		}
		//DB처리
		BoardDAO dao=DAOManager.getBoardDAO();
		//메서드 실행후 디테일정보 리턴
		BoardDTO dto=dao.detail(no);
		request.setAttribute("dto", dto);
		T_File fileInfo=dao.detailFile(no);
		if(fileInfo!=null) {
			request.setAttribute("fileInfo", fileInfo);
			
		}
		
		String path="/WEB-INF/view/board/detail.jsp";
		return path;
	}

}
