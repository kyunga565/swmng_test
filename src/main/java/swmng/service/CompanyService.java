package swmng.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import swmng.dto.Company;
import swmng.mappers.CompanyMapper;
import swmng.util.MybatisSqlSessionFactory;

public class CompanyService {
	private static final CompanyService instance = new CompanyService();

	public static CompanyService getInstance() {
		return instance;
	}

	private CompanyService() {
	}

	private static final Logger logger = Logger.getLogger(CompanyService.class);

	public List<Company> selectList() {
		logger.debug("selectList()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();

		try {
			CompanyMapper cm = sqlSession.getMapper(CompanyMapper.class);
			return cm.selectList();
		} finally {
			sqlSession.close();
		}
	}

	public void insertList(Company com) {
		logger.debug("insertList()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();

		try {
			CompanyMapper cm = sqlSession.getMapper(CompanyMapper.class);
			cm.insertList(com);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public int updateList(Company com) {
		if (logger.isDebugEnabled()) {
			logger.debug("updateList(com) - start");
		}
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			CompanyMapper cm = sqlSession.getMapper(CompanyMapper.class);
			int res = cm.updateList(com);
			sqlSession.commit();
			return res;
		} finally {
			sqlSession.close();
		}
	}

	public Company selectNo(int no) {
		logger.debug("selectList()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();

		try {
			CompanyMapper cm = sqlSession.getMapper(CompanyMapper.class);
			Company returnList = cm.selectNo(no);
			return (Company) returnList;
		} finally {
			sqlSession.close();
		}
	}

	public int deleteList(int no) {
		logger.debug("deleteList()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();

		try {
			CompanyMapper cm = sqlSession.getMapper(CompanyMapper.class);
			int res = cm.deleteList(no);
			sqlSession.commit();
			return res;
		} finally {
			sqlSession.close();
		}
	}

	public Company IncNo() {
		logger.debug("IncNo()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			CompanyMapper cm = sqlSession.getMapper(CompanyMapper.class);
			Company returnlist = cm.IncNo();
			return returnlist;
		} finally {
			sqlSession.close();
		}
	}
}
