package us.onesquare.bastoji.rating;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Rating {
	
	@PrimaryKey
	private UUID id;
	
	private UUID userId;
	
	private UUID reviewedId;
	
	private Integer score;
	
	private String comment;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getReviewedId() {
		return reviewedId;
	}

	public void setReviewedId(UUID reviewedId) {
		this.reviewedId = reviewedId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
}
