package us.onesquare.bastoji;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import us.onesquare.bastoji.model.Company;

/**
 * Unit test for simple App.
 */
public class AppTest {

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	@Autowired
	CompanyRepository companyRepository;

	@Test
	public Company findCompanyByMail() {
		String email = "wissal.benslama14@gmail.com";
		System.out.println("successssssssssssssss");
		return companyRepository.findCompanyByMail(email) ;
	}
}
