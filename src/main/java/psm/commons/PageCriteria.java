package psm.commons;

public class PageCriteria {
	protected int page; 
	protected int rows;  //how many rows in 1 page
	
	public PageCriteria() {
		this.page = 1;
		this.rows = 10;
	}
	
	public int getPage() {
		return page;
	}
	public PageCriteria setPage(int page) {
		this.page = page;
		return this;
	}
	public int getRows() {
		return rows;
	}
	public PageCriteria setRows(int rows) {
		
		if(rows<0 || rows>50) {
			this.rows = 10;
		}else {
			this.rows = rows;
		}
		
		return this;
	}
	
	public int getPageStart() {
		return (page-1)*rows;
	}
	
}
