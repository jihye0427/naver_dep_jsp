package mybatisConf;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MabytisManager {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		
		//생성자를 한번만 호출하도록 if처리
		if(sqlSessionFactory==null)
			new MabytisManager();
		
		return sqlSessionFactory;
	}
	
	
	//외부에서 접근하지 못하도록 private
	private MabytisManager() {
		String resource = "/mybatisConf/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
