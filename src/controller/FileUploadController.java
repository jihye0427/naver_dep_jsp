package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DAOManager;
import dto.BoardDTO;
import dto.T_File;


@WebServlet("*.fi")
@MultipartConfig(
		location = "D:\\jsp\\workspace\\temp", //업로드한 파일이 임시로 저장될 위치
		maxFileSize = -1, //업로드 가능한 파일의 최대크기 바이트 단위로 지정
		fileSizeThreshold = -1, //전체 요청데이터의 최대크기 설정
		maxRequestSize = -1 //-1은 제한없음
		)
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		System.out.println(writer);
		System.out.println(subject);
		System.out.println(content);
		Part filePart=request.getPart("file");
		
		String original_file_name=filePart.getSubmittedFileName();
		
		String[] strs=original_file_name.split("[.]");
		String new_file_name=strs[0]+"_"+System.nanoTime()+"."+strs[1];
		
		
		
		long file_size=filePart.getSize();
		System.out.println(original_file_name);
		System.out.println(file_size/1024L+" kb");
		if(file_size>0) {
			String path="D:\\jsp\\workspace\\JSP10_2\\WebContent\\upload\\";
			filePart.write(path+new_file_name);
			
		}
		
		//DB로
		BoardDTO board=new BoardDTO();
		board.setWriter(writer);
		board.setSubject(subject);
		board.setContent(content);
		board.setUser_ip(request.getRemoteAddr());
		
		DAOManager.getBoardDAO().insertBoard(board);
		
		System.out.println("게시글 등록완료");
		System.out.println("게시글 번호"+board.getNo());
		
		T_File file=new T_File();
		file.setBoard_no(board.getNo());
		file.setOriginal_file_name(original_file_name);
		file.setStored_file_path("/upload/"+new_file_name);
		DAOManager.getBoardDAO().insertFile(file);
		
		response.sendRedirect("board.bo");
		
	
	
		
	}

}
