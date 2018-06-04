package us.onesquare.bastoji.model.exchange;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
@Table
public class AgreementWithoutEscrow {


	@PrimaryKey
	private UUID id;
	
	private Long idProvider;
	
	private Long idBeneficiary;
	
	private Double funds;
	
	private Integer agreementStatus;
	
	private Date agreementDeadLine;

	

}
