package dao;

public class DAOManager {
	private static BoardDAO dao=new BoardDAO();
	private static MemberDAO memberDao=new MemberDAO();
	public static BoardDAO getBoardDAO() {
		return dao;
	}
	
	public static MemberDAO getMemberDAO() {
		return memberDao;
	}
	private DAOManager(){}
}
