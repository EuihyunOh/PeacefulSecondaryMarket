package psm.vo;

import java.util.Date;

public class Member {
	protected String id;
	protected String password;
	protected String address;
	protected String tradeName;
	protected String account;
	protected Date joinDate;
	protected String phone;
	
	public String getId() {
		return id;
	}
	public Member setId(String id) {
		this.id = id;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Member setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public Member setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getTradeName() {
		return tradeName;
	}
	public Member setTradeName(String tradeName) {
		this.tradeName = tradeName;
		return this;
	}
	public String getAccount() {
		return account;
	}
	public Member setAccount(String account) {
		this.account = account;
		return this;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public Member getJoinDate(Date joinDate) {
		this.joinDate = joinDate;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public Member setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	}
