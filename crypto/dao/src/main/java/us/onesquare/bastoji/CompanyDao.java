package us.onesquare.bastoji;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.CodecRegistry;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.TypeCodec;

public class CompanyDao {
	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}

	public static void main(String[] args) throws Exception {
		// Connect to the cluster and keyspace "devjavasource"
		final Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		final Session session = cluster.connect("javasampleapproach");

		// Retrieve all User details from Users table
		System.out.println("\n*********Retrive Company Data *************");
		//getUsersAllDetails(session);

		// Insert new User into users table
		System.out.println("\n*********Insert Company Data  *************");

		PreparedStatement prepared = session.prepare("insert into company (id, userId, idContactDetails ,idLogo,email,companyId,address,idTax,companyName,phoneNumber,description,creationDate,industry,companyCategory,isIdentityValidated,isAddressValidated,userCategory,isPhoneValidated) values (?, ? ,?,?, ? ,?,?, ? ,?,?, ? ,?,?, ? ,?,?, ? ,?)");
		String target = "2011-02-03";
		DateFormat df = new SimpleDateFormat("yyyyy-mm-dd");
		java.util.Date result =  df.parse(target); 
		System.out.println("dateeeeeeeeeeeeeeeeeeeeeee" +result);
		CodecRegistry codecRegistry = new CodecRegistry();
		codecRegistry.register(new TimestampAsStringCodec(TypeCodec.date(), Date.class));
		Cluster.builder().withCodecRegistry(codecRegistry).build();
		BoundStatement bound = prepared.bind(UUID.randomUUID(), 1l,2l,3l,"aaa","bb","cc","dd","ee","ff","ggg",result,"hh","iii",true,false,"INDIVIDUAL",true);
		System.out.println("inseeeeeeeert" + bound);
		session.execute(bound);

		getUsersAllDetails(session);

		// Update user data in users table
		System.out.println("\n*********Update Company Data  *************");
		session.execute("update company set address='new address'  where userId = 1");
		getUsersAllDetails(session);

		// Delete user from users table
		System.out.println("\n*********Delete Company Data  *************");
		session.execute("delete FROM company where userId = 2");
		getUsersAllDetails(session);

	}

	

	private static void getUsersAllDetails(final Session inSession) {
		// Use select to get the users table data
		ResultSet results = inSession.execute("SELECT * FROM company");
		for (Row row : results) {
			System.out.format("%s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s \n", row.getUUID("id"),row.getLong("userId"),row.getLong("idContactDetails"),row.getLong("idLogo"),row.getString("email"),row.getString("companyId"),row.getString("address"),row.getString("idTax"),row.getString("companyName"),row.getString("phoneNumber"),row.getString("description"),row.getDate("creationDate"),row.getString("industry"),row.getString("companyCategory"),row.getBool("isIdentityValidated"),row.getBool("isAddressValidated"),row.getString("userCategory"),row.getBool("isPhoneValidated"));
		}
	}


}
