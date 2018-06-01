package us.onesquare.bastoji.service;

import java.util.List;
import java.util.UUID;

import us.onesquare.bastoji.model.admin.IdentityProof;

public interface IIdentityProofDao {
	
	public IdentityProof createIdentityProof(IdentityProof identityProof);

	public IdentityProof getIdentityProof(UUID id);

	public void updateIdentityProof(IdentityProof identityProof);

	public void deleteIdentityProof(UUID id);

	public void deleteAll();

	public List<IdentityProof> getAllIdentityProofs();
}
