package us.onesquare.bastoji;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class App {
    	    public static void main(String[] args) {
    	 
    	        // Connect to the cluster and keyspace "devjavasource"
    	        final Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1")
    	                .build();       
    	        final Session session = cluster.connect("javasampleapproach");
    	         
    	        System.out.println("*********Cluster Information *************");
    	        System.out.println(" Cluster Name is: " + cluster.getClusterName() );
    	        System.out.println(" Driver Version is: " + cluster.getDriverVersion() );
    	        System.out.println(" Cluster Configuration is: " + cluster.getConfiguration() );
    	        System.out.println(" Cluster Metadata is: " + cluster.getMetadata() );
    	        System.out.println(" Cluster Metrics is: " + cluster.getMetrics() );        
    	         
    	        // Retrieve all User details from Users table
    	        System.out.println("\n*********Retrive User Data Example *************");        
    	        getUsersAllDetails(session);
    	         
    	        // Insert new User into users table
    	        System.out.println("\n*********Insert User Data Example *************");        
    	        session.execute("INSERT INTO user (id, email, password) VALUES (1, 'email@gmail.tn', 'Stuatr')");
    	        getUsersAllDetails(session);
    	         
//    	        // Update user data in users table
//    	        System.out.println("\n*********Update User Data Example *************");        
//    	        session.execute("update users set address = 'USA NEW' where id = 11104");
//    	        getUsersAllDetails(session);
//    	         
//    	        // Delete user from users table
//    	        System.out.println("\n*********Delete User Data Example *************");        
//    	        session.execute("delete FROM users where id = 11104");
//    	        getUsersAllDetails(session);
//    	         
//    	        // Close Cluster and Session objects
//    	        System.out.println("\nIs Cluster Closed :" + cluster.isClosed());
//    	        System.out.println("Is Session Closed :" + session.isClosed());     
//    	        cluster.close();
//    	        session.close();
//    	        System.out.println("Is Cluster Closed :" + cluster.isClosed());
//    	        System.out.println("Is Session Closed :" + session.isClosed());
    	    }
    	     
    	    private static void getUsersAllDetails(final Session inSession){        
    	        // Use select to get the users table data
    	        ResultSet results = inSession.execute("SELECT * FROM user");
    	        for (Row row : results) {
    	            System.out.format("%s %d %s\n", 
    	                    row.getInt("id"), row.getString("email"), row.getString("password"));
    	        }
    	    }
    	
    }


