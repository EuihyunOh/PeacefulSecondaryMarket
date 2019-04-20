package psm.vo;

public class Attach {
	protected int fileNo;
	protected int tradeNo;
	protected String fileName;
	
	public int getFileNo() {
		return fileNo;
	}
	public Attach setFileNo(int fileNo) {
		this.fileNo = fileNo;
		return this;
	}
	public int getTradeNo() {
		return tradeNo;
	}
	public Attach setTradeNo(int tradeNo) {
		this.tradeNo = tradeNo;
		return this;
	}
	public String getFileName() {
		return fileName;
	}
	public Attach setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}
}
