package us.onesquare.bastoji;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

import us.onesquare.bastoji.dao.ITiersDao;
import us.onesquare.bastoji.model.admin.Tiers;

@Component
public class TiersDao implements ITiersDao{
	
	@Autowired
	private Session session;
	
	@Override
	public Tiers createTiers(Tiers tier) {
		System.out.println("\n*********Insert User Data Example *************");

		PreparedStatement prepared = session.prepare("insert into tier (id, idCard, passport,firstName,lastName,birthdate,gender,idPhoto,Address,email,function,facebook,idTradingExperience,subscriptionDate,phoneNumber,idTax) values (?, ? ,?,?, ? ,?,?, ? ,?,?, ? ,?,?, ? ,?,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), tier.getIdCard(),tier.getPassport(),tier.getFirstName(),tier.getLastName(),tier.getBirthdate(),tier.getGender(),tier.getIdPhoto(),tier.getAddress(),tier.getEmail(),tier.getFunction(),tier.getFacebook(),tier.getIdTradingExperience(),tier.getSubscriptionDate(),tier.getPhoneNumber(),tier.getIdTax());
		session.execute(bound);
           return tier ;
	}

	@Override
	public Tiers getTiers(UUID id) {
		Tiers t =(Tiers) session.execute("select * from tiers where id=?" , id);
		return t ;
	
	}

	@Override
	public void updateTiers(Tiers tier) {
		session.execute("update tier set idCard=? ,passport=? ,firstName=? ,lastName=? ,birthdate=? ,gender=? ,idPhoto=? , Address=? ,email=? , function=? , facebook=? , idTradingExperience=? , subscriptionDate=? , phoneNumber=? , idTax=?  " + "  where id = ?" ,tier.getIdCard(),tier.getPassport(),tier.getFirstName(),tier.getLastName(),tier.getBirthdate(),tier.getGender(),tier.getAddress(),tier.getEmail(),tier.getFunction(),tier.getFacebook(),tier.getIdTradingExperience(),tier.getSubscriptionDate(),tier.getPhoneNumber(),tier.getIdTax());
	}

	@Override
	public void deleteTiers(UUID id) {
		
		session.execute("delete FROM tiers where id =?"  );
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tiers> getAllTierss() {
		 List list= (List) session.execute("SELECT * FROM tiers");
			
			
			return list;
	}

	
	
	
	
	
	
	

}
