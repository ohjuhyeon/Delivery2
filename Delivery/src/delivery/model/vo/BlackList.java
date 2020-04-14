package delivery.model.vo;

public class BlackList {

	private String strId;
	private String keyword;
	private int blNo;
	private String admin;

	public BlackList() {
	}

	public BlackList(String strId, String keyword, int blNo, String admin) {
		super();
		this.strId = strId;
		this.keyword = keyword;
		this.blNo = blNo;
		this.admin = admin;
	}

	public String getStrId() {
		return strId;
	}

	public void setStrId(String strId) {
		this.strId = strId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getBlNo() {
		return blNo;
	}

	public void setBlNo(int blNo) {
		this.blNo = blNo;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return this.strId + " , " + this.keyword + " , " + this.blNo + " , " + this.admin;
	}

}
