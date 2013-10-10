package com.cts.shield.model;

import java.util.Date;
public class Shield {
	private String msisdn;
	private Date date;
	private String vagever;
	private Integer status;
	private String surname;
	private String forename;
	private String title;
	private Integer houseNumber;
	private String houseName;
	private String streetName;
	private String postCode;
	private Date dateOfBirth;
	private String cardNumber;
	private String ageVerMethod;
	private String ageVerPin;
	private String parentalControlPin;
	private Boolean useDataMarketing;
	private String actionedBy;
	private String channelId;
	private String actionChannelID;
	private Integer paymentType;
	private Integer businessUserFlag;
	public Integer getMaxAvAttempt() {
		return maxAvAttempt;
	}
	public void setMaxAvAttempt(Integer maxAvAttempt) {
		this.maxAvAttempt = maxAvAttempt;
	}
	public Integer getPrevioudStatus() {
		return previoudStatus;
	}
	public void setPrevioudStatus(Integer previoudStatus) {
		this.previoudStatus = previoudStatus;
	}
	private Integer avAttemptNo;
	private Integer maxAvAttempt;
	private Integer previoudStatus;
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getVagever() {
		return vagever;
	}
	public void setVagever(String vagever) {
		this.vagever = vagever;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getAgeVerMethod() {
		return ageVerMethod;
	}
	public void setAgeVerMethod(String ageVerMethod) {
		this.ageVerMethod = ageVerMethod;
	}
	public String getAgeVerPin() {
		return ageVerPin;
	}
	public void setAgeVerPin(String ageVerPin) {
		this.ageVerPin = ageVerPin;
	}
	public String getActionChannelID() {
		return actionChannelID;
	}
	public void setActionChannelID(String actionChannelID) {
		this.actionChannelID = actionChannelID;
	}
	public Integer getAvAttemptNo() {
		return avAttemptNo;
	}
	public void setAvAttemptNo(Integer avAttemptNo) {
		this.avAttemptNo = avAttemptNo;
	}
	public String getParentalControlPin() {
		return parentalControlPin;
	}
	public void setParentalControlPin(String parentalControlPin) {
		this.parentalControlPin = parentalControlPin;
	}
	public Boolean getUseDataMarketing() {
		return useDataMarketing;
	}
	public void setUseDataMarketing(Boolean useDataMarketing) {
		this.useDataMarketing = useDataMarketing;
	}
	public String getActionedBy() {
		return actionedBy;
	}
	public void setActionedBy(String actionedBy) {
		this.actionedBy = actionedBy;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public Integer getBusinessUserFlag() {
		return businessUserFlag;
	}
	public void setBusinessUserFlag(Integer businessUserFlag) {
		this.businessUserFlag = businessUserFlag;
	}
}
