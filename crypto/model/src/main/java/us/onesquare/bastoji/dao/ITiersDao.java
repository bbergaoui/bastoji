package us.onesquare.bastoji.dao;

import java.util.List;
import java.util.UUID;

import us.onesquare.bastoji.model.admin.Tiers;

public interface ITiersDao {
	public Tiers createTiers(Tiers photo);

	public Tiers getTiers(UUID id);

	public void updateTiers(Tiers photo);

	public void deleteTiers(UUID id);
	
	public void deleteAll();

	public List<Tiers> getAllTierss();
}
