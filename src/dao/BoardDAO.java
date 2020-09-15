package dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BoardDTO;
import dto.Reply;
import dto.T_File;
import mybatisConf.MabytisManager;
import vo.SortInfo;

public class BoardDAO implements DAO{
	

	public List<BoardDTO> boardList(RowBounds rowBounds) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<BoardDTO> list=sqlSession.selectList("board.boardList", null, rowBounds);
		sqlSession.close();
		return list;
	}

	public int boardTotal() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int boardTotal=sqlSession.selectOne("board.boardTotal");
		sqlSession.close();
		return boardTotal;
	}

	public void insertBoard(BoardDTO board) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		sqlSession.insert("board.insetBoard", board);
		sqlSession.close();
		
	}

	public BoardDTO detail(int no) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		BoardDTO dto=sqlSession.selectOne("board.detail", no);
		sqlSession.close();
		return dto;
	}

	public void delete(int no) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		
		sqlSession.delete("board.delete", no);
		//sqlSession.commit();
		sqlSession.close();
		
	}

	public void addReply(Reply reply) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		
		sqlSession.insert("board.addReply", reply);
		
		sqlSession.close();
		
	}

	public List<Reply> getReply(SortInfo sortInfo) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Reply> result=sqlSession.selectList("board.getReply", sortInfo);
		sqlSession.close();
		return result;
	}

	//추천수 증가...
	public void incRecommend(int no) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		
		sqlSession.update("board.incRecommend",no);
		
		sqlSession.close();
	}

	public void insertFile(T_File file) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		
		sqlSession.insert("board.insertFile",file);
		
		sqlSession.close();
		
	}

	public T_File detailFile(int board_no) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		T_File fileInfo=sqlSession.selectOne("board.selectFile",board_no);
		
		sqlSession.close();
		
		return fileInfo;
	}

	

}
