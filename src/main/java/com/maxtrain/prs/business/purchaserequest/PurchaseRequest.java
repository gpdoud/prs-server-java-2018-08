package com.maxtrain.prs.business.purchaserequest;

import java.time.*;
import javax.persistence.*;

import com.maxtrain.prs.business.user.User;

@Entity
public class PurchaseRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	private String description;
	private String justification;
	private LocalDate dateNeeded;
	private String deliverymode;
	private String status;
	private double total;
	private LocalDateTime submitteddate;
	private String reasonForRejection;
	
	private static final String STATUS_NEW = "NEW";
	private static final String STATUS_EDIT = "EDIT";
	private static final String STATUS_REVIEW = "REVIEW";
	private static final String STATUS_APPROVED = "APPROVED";
	private static final String STATUS_REJECTED = "REJECTED";
	
	public PurchaseRequest() {
		super();
	}
	
	public PurchaseRequest(int id, User user, String description, String justification, LocalDate dateNeeded,
			String deliverymode, String status, double total, LocalDateTime submitteddate, String reasonForRejection) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.justification = justification;
		this.dateNeeded = dateNeeded;
		this.deliverymode = deliverymode;
		this.status = status;
		this.total = total;
		this.submitteddate = submitteddate;
		this.reasonForRejection = reasonForRejection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public LocalDate getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(LocalDate dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public String getDeliverymode() {
		return deliverymode;
	}

	public void setDeliverymode(String deliverymode) {
		this.deliverymode = deliverymode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDateTime getSubmitteddate() {
		return submitteddate;
	}

	public void setSubmitteddate(LocalDateTime submitteddate) {
		this.submitteddate = submitteddate;
	}

	public String getReasonForRejection() {
		return reasonForRejection;
	}

	public void setReasonForRejection(String reasonForRejection) {
		this.reasonForRejection = reasonForRejection;
	}
	
	

}
