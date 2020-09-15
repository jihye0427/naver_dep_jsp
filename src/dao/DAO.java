package dao;

import org.apache.ibatis.session.SqlSessionFactory;

import mybatisConf.MabytisManager;

public interface DAO {
	
	SqlSessionFactory sqlSessionFactory=MabytisManager.getSqlSessionFactory();;

}
