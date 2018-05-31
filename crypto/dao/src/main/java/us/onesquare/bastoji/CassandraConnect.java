package us.onesquare.bastoji;
import org.junit.Before;
import org.junit.Test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Session;

public class CassandraConnect {
	
		 
	    private static Cluster cluster;
	 
	    private static Session session;
	 
	    public static Cluster connect (String node) {
	       return Cluster.builder().addContactPoint(node).build();    }
	    public static void main(String[]args)
	    {
	    	//create and connect database(bastoujjjjji)hh
	    	cluster =connect("127.0.0.1");
	    	session=cluster.connect();
	    	session.execute("CREATE KEYSPACE Bastoji WITH replication = " + "{'class':'SimpleStrategy','replication_factor':1};" );
	    	session.execute("USE Bastoji");
	    	  session.close();
		      cluster.close();
	    }
	
	  
	  
	}

