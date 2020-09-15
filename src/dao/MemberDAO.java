package dao;

import org.apache.ibatis.session.SqlSession;

import dto.Login;
import dto.Member;

public class MemberDAO implements DAO{

	public void addMember(Member member) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		sqlSession.insert("member.addMember", member);
		//sqlSession.commit();
		sqlSession.close();
	}

	public int idCheck(String id) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int result=sqlSession.selectOne("member.idCheck",id);
		sqlSession.close();
		return result;
	}

	public Member login(Login log) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		Member result=sqlSession.selectOne("member.login", log);
		
		sqlSession.close();
		return result;
	}
}
