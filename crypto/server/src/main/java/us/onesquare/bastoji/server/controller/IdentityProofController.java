package us.onesquare.bastoji.server.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;

import us.onesquare.bastoji.dao.IIdentityProofDao;
import us.onesquare.bastoji.model.admin.IdentityProof;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class IdentityProofController {
	@Autowired
	IIdentityProofDao identityProofDao;
	@GetMapping("/identityProofs")
	public List<IdentityProof> getAllIdentityProofs() {
		System.out.println("Get all Identity Proofs...");

		List<IdentityProof> identityProofs = new ArrayList<>();
		identityProofDao.getAllIdentityProofs();
		return identityProofs;
	}
	@PostMapping("/identityProofs/create")
	public ResponseEntity<IdentityProof> createIdentityProof(@Valid @RequestBody IdentityProof identityProof) {
		System.out.println("Create Identity Proof: " + identityProof.getId() + "...");

		identityProof.setId(UUIDs.timeBased());
		IdentityProof _identityProof = identityProofDao.createIdentityProof(identityProof);
		return new ResponseEntity<>(_identityProof, HttpStatus.OK);
	}
	@PutMapping("/identityProofs/{id}")
	public ResponseEntity<IdentityProof> updateIdentityProof(@PathVariable("id") UUID id, @RequestBody IdentityProof identityProof) {
		System.out.println("Update Identity Proof with ID = " + id + "...");

		IdentityProof identityProofData = identityProofDao.getIdentityProof(id);
		if (identityProofData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		identityProofData.setDescription(identityProof.getDescription());
		identityProofData.setProof(identityProof.getProof());
		identityProofData.setThumbnail(identityProof.getThumbnail());
		identityProofData.setUserId(identityProof.getUserId());
		

		
		identityProofDao.updateIdentityProof(identityProofData);
		return new ResponseEntity<>(identityProofData, HttpStatus.OK);
	}
	@DeleteMapping("/identityProofs/{id}")
	public ResponseEntity<String> deleteIdentityProof(@PathVariable("id") UUID id) {
		System.out.println("Delete Identity Proof with ID = " + id + "...");

		identityProofDao.deleteIdentityProof(id);

		return new ResponseEntity<>("Identity Proof has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/identityProofs/delete")
	public ResponseEntity<String> deleteAllIdentityProofs() {
		System.out.println("Delete All identity Proofs...");

		identityProofDao.deleteAll();

		return new ResponseEntity<>("All identity Proofs have been deleted!", HttpStatus.OK);
	}


}
