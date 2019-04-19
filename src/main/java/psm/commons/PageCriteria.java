package psm.commons;

public class PageCriteria {
	protected int page; 
	protected int rows;  //how many rows in 1 page
	protected int paginationStart;
	protected int paginationGroup;
	
	public PageCriteria() { // default = 10 rows/page
		page = 1;
		rows = 10;
		paginationGroup = 5;
		setPaginationStart(1);
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
	public int getPaginationStart() {
		return paginationStart;
	}
	public PageCriteria setPaginationStart(int page) {
		this.paginationStart = ((page-1)/paginationGroup)*paginationGroup+1;
		return this;
	}
	public int getPaginationGroup() {
		return paginationGroup;
	}
	public PageCriteria setPaginationGroup(int paginationGroup) {
		this.paginationGroup = paginationGroup;
		return this;
	}
	
	public int getPageStart() {
		return (page-1)*rows;
	}	
	
}
