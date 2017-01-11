package swmng;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import swmng.dto.Company;
import swmng.service.CompanyService;

public class CompanyTest {
	private static CompanyService cs;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cs = CompanyService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		cs = null;
	}

	/*	@Test
	public void selectListtest() {
		
		List<Company> selectList = cs.selectList();
		Assert.assertNotNull(selectList);
		
		for(Company com : selectList){
			Assert.assertNotNull(com);
			System.out.println(com);
		}
		
		
	}
	@Test
	public void insertListtest(){
		Company com = new Company(8,"경ㅇ:", "ㅁㅈㅂㄷ", "ㄹㅇ");
	
	}
	
	@Test
	public void testupdateList(){
		Company com = new Company();
		com.setNo(7);
		com.setCoName("경쓰");
		com.setAddress("eornrnrn");
		com.setTel("111-111-1111");
		
		int result = cs.updateList(com);
		Assert.assertSame(1, result);
	}
	@Test
	public void selectNotest() {
		
		List<Company> selectList = (List<Company>) cs.selectNo(8);
		Assert.assertNotNull(selectList);
		
		for(Company com : selectList){
			Assert.assertNotNull(com);
			System.out.println(com);
		}
	}
	@Test
	public void deleteTest(){
		int delete = CompanyService.getInstance().deleteList(6767);
		
		Assert.assertSame(1, delete);
	}*/
	@Test
	public void incNotest() {
		Company com = new Company();
		com.setCoName("경ㅇㅇ아");
		com.setAddress("대구아이티");
		com.setTel("123");
		
		Company result = cs.IncNo();
		Assert.assertSame(result, result);
	}
}
