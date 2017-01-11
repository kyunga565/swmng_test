package swmng.mappers;

import java.util.List;

import swmng.dto.Company;

public interface CompanyMapper {
	List<Company> selectList();
	void insertList(Company com);
	int updateList(Company com);
	Company selectNo(int no);
	Company IncNo();
	int deleteList(int no);
}
