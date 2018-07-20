package com.revature.models;

import java.util.Arrays;
import java.util.Date;

public class ReimbursementRequest {
	private int reimbursementId;
	private long reimbursementAmount;
	private Date submitted;
	private Date resolved;
	private String description;
	private byte[] receipt;
	private ERSUser author;
	private ERSUser resolver;
	private ReimbursementType type;
	private ReimbursementStatus status;
	
	public ReimbursementRequest(int reimbursementId, long reimbursementAmount, Date submitted, String description,
			ERSUser author, ReimbursementType type, ReimbursementStatus status) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.submitted = submitted;
		this.description = description;
		this.author = author;
		this.type = type;
		this.status = status;
	}

	public ReimbursementRequest(int reimbursementId, long reimbursementAmount, Date submitted, String description,
			byte[] receipt, ERSUser author, ReimbursementType type, ReimbursementStatus status) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.submitted = submitted;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.type = type;
		this.status = status;
	}

	public ReimbursementRequest(int reimbursementId, long reimbursementAmount, Date submitted, Date resolved,
			String description, ERSUser author, ERSUser resolver, ReimbursementType type, ReimbursementStatus status) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}

	public ReimbursementRequest(int reimbursementId, long reimbursementAmount, Date submitted, Date resolved,
			String description, byte[] receipt, ERSUser author, ERSUser resolver, ReimbursementType type,
			ReimbursementStatus status) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public long getReimbursementAmount() {
		return reimbursementAmount;
	}

	public Date getSubmitted() {
		return submitted;
	}

	public Date getResolved() {
		return resolved;
	}

	public String getDescription() {
		return description;
	}

	public byte[] getReceipt() {
		return receipt;
	}

	public ERSUser getAuthor() {
		return author;
	}

	public ERSUser getResolver() {
		return resolver;
	}

	public ReimbursementType getType() {
		return type;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "ReimbursementRequest [reimbursementId=" + reimbursementId + ", reimbursementAmount="
				+ reimbursementAmount + ", submitted=" + submitted + ", resolved=" + resolved + ", description="
				+ description + ", receipt=" + Arrays.toString(receipt) + ", author=" + author + ", resolver="
				+ resolver + ", type=" + type + ", status=" + status + "]";
	}
	
}
