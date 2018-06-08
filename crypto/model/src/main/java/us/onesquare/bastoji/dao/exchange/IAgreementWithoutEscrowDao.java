package us.onesquare.bastoji.dao.exchange;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import us.onesquare.bastoji.model.exchange.AgreementWithoutEscrow;

public interface IAgreementWithoutEscrowDao {

	AgreementWithoutEscrow createAgreementWithoutEscrow(AgreementWithoutEscrow agreementWithoutEscrow);

	AgreementWithoutEscrow getAgreementWithoutEscrow(UUID id);

	void updateAgreementWithoutEscrow(AgreementWithoutEscrow agreementWithoutEscrow);

	void deleteAgreementWithoutEscrows(Collection<UUID> AgreementWithoutEscrows);

	List<AgreementWithoutEscrow> getAllAgreementWithoutEscrows();

	void deleteAll(Long first,Long limit);


}
