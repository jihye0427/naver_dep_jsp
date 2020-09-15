package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;

import action.Action;
import action.board.BoardAction;
import action.board.DeteilAction;
import action.board.WriteAction;

//@WebServlet(urlPatterns = {"*.me"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> actionMap=new Hashtable<String, Action>();
	
	
   //BoardController 최초 실행시 한번만 실행되는 메서드...
	@Override
	public void init() throws ServletException {
		
		//boardClass-info.properties 정보를 map에저장
		
		try {
			Properties prop=Resources.getResourceAsProperties("/action/member/memberClass-info.properties");
			Set<Object> keys=prop.keySet();
			
			for(Object obj:keys) {
				//map에 저장할 key
				String key= (String )obj;
				
				String className=(String)prop.get(key);
				//문자열의 클래스이름을 객체로 만들자
				try {
					//map에 저장할 객체생성
					//Action action=(Action) Class.forName(className).newInstance();
					//9버전이상에서는
					Action action=(Action) Class.forName(className).getDeclaredConstructor().newInstance();
					
					//클래스멤버의 Map에 저장
					actionMap.put(key, action);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController 처리");
		/* url이 어떤페이지를 원하는지 분석 */
		String uri=request.getRequestURI();
		//경로중 제일 마지막 문자열만 추출
		String[] strs=uri.split("/");
		String key=strs[strs.length-1];//board.bo
		
		
		//key에 해당하는객체를  map에서 객체를 갖고온다.
		Action action=actionMap.get(key);
		
		
		String path=null;
		//로직처리후 이동할 페이지 주소 리턴받는다
		path=action.process(request, response);
		
		//페이지로 이동
		if(path!=null)
			request.getRequestDispatcher(path).forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
