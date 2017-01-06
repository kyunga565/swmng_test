package swmng.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import swmng.dto.Company;
import swmng.mappers.CompanyMapper;
import swmng.util.MybatisSqlSessionFactory;


public class CompanyService{
	private static final CompanyService instance = new CompanyService();

	public static CompanyService getInstance() {
		return instance;
	}
	
	private CompanyService(){}
	
	private static final Logger logger = Logger.getLogger(CompanyService.class);
	
	public List<Company> selectList(){
		logger.debug("selectList()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			CompanyMapper cm = sqlSession.getMapper(CompanyMapper.class);
			return cm.selectList();
		}finally{
			sqlSession.close();
		}
	}

}
