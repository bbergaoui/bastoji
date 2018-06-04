package us.onesquare.bastoji;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import us.onesquare.bastoji.dao.IIdentityProofDao;
import us.onesquare.bastoji.model.admin.IdentityProof;

@Component
public class IdentityProofDao implements IIdentityProofDao {

	@Override
	public IdentityProof createIdentityProof(IdentityProof identityProof) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentityProof getIdentityProof(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateIdentityProof(IdentityProof identityProof) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteIdentityProof(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IdentityProof> getAllIdentityProofs() {
		// TODO Auto-generated method stub
		return null;
	}

}
