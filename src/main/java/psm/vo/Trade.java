package psm.vo;

import java.util.Date;

public class Trade {
	protected int no;
	protected String title;
	protected Date createDate;
	protected String id;
	protected String tradeName;
	protected float price;
	protected int condition;
	protected int state;
	protected String content;
	protected String dealId;
	
	public int getNo() {
		return no;
	}
	public Trade setNo(int no) {
		this.no = no;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Trade setTitle(String title) {
		this.title = title;
		return this;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public Trade setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	public String getId() {
		return id;
	}
	public Trade setId(String id) {
		this.id = id;
		return this;
	}
	public String getTradeName() {
		return tradeName;
	}
	public Trade setTradeName(String tradeName) {
		this.tradeName = tradeName;
		return this;
	}
	public float getPrice() {
		return price;
	}
	public Trade setPrice(float price) {
		this.price = price;
		return this;
	}
	public int getCondition() {
		return condition;
	}
	public Trade setCondition(int condition) {
		this.condition = condition;
		return this;
	}
	public int getState() {
		return state;
	}
	public Trade setState(int state) {
		this.state = state;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Trade setContent(String content) {
		this.content = content;
		return this;
	}
	public String getDealId() {
		return dealId;
	}
	public Trade setDealId(String dealId) {
		this.dealId = dealId;
		return this;
	}
	
}
