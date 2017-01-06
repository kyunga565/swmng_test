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

	@Test
	public void selectListtest() {
		
		List<Company> selectList = cs.selectList();
		Assert.assertNotNull(selectList);
		
/*		for(Company com : selectList){
			Assert.assertNotNull(com);
			System.out.println(com);
		}
		*/
		
	}
}
