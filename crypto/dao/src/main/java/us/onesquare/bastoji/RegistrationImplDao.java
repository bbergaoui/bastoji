package us.onesquare.bastoji;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

import us.onesquare.bastoji.dao.IRegistrationDao;
import us.onesquare.bastoji.model.subscription.Registration;

@Component
public class RegistrationImplDao implements IRegistrationDao {

    @Autowired
    private Session session;

    @Autowired
    private CassandraOperations cassandraOperations;

    public static Cluster connect(String node) {
        return Cluster.builder().addContactPoint(node).build();

    }

    @Override
    public Registration createRegistration(Registration registration) {

        cassandraOperations.insert(registration);
        return registration;
    }

    @Override
    public Registration getRegistration(UUID id) {
        Registration u = (Registration) session.execute("select * from registration where id=?", id);
        return u;
    }

    @Override
    public void updateRegistration(Registration registration) {

        cassandraOperations.update(registration);

    }

    @Override
    public void deleteRegistrations(Collection<UUID> registrations) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (UUID id : registrations) {
            list.add(new Object[]{id});
        }
        session.execute("delete FROM registration where id =?", list);

    }

    @Override
    public List<Registration> getAllRegistrations() {

        return cassandraOperations.select("SELECT * FROM registration", Registration.class);

    }

    @Override
    public void deleteRegistration(UUID id) {
        session.execute("delete FROM registration where id =?", id);

    }

    @Override
    public boolean userExists(String email) {
        return false;
    }

    @Override
    public Registration findByToken(String token) {
        PreparedStatement statement = session.prepare("select * from registration where mailconfirmationtoken=? ALLOW FILTERING");

        BoundStatement bound = statement.bind(token);
        return cassandraOperations.selectOne(bound, Registration.class);
    }
}
