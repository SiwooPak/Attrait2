package www.model.code;

public class CodeDTO {
	private String commTyCd;
	private String commCd;
	private String commCdNm;
	
	public CodeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CodeDTO(String commTyCd, String commCd, String commCdNm) {
		super();
		this.commTyCd = commTyCd;
		this.commCd = commCd;
		this.commCdNm = commCdNm;
	}

	public String getCommTyCd() {
		return commTyCd;
	}

	public void setCommTyCd(String commTyCd) {
		this.commTyCd = commTyCd;
	}

	public String getCommCd() {
		return commCd;
	}

	public void setCommCd(String commCd) {
		this.commCd = commCd;
	}

	public String getCommCdNm() {
		return commCdNm;
	}

	public void setCommCdNm(String commCdNm) {
		this.commCdNm = commCdNm;
	}

	@Override
	public String toString() {
		return "CodeDTO [commTyCd=" + commTyCd + ", commCd=" + commCd + ", commCdNm=" + commCdNm + "]";
	}
	
}
