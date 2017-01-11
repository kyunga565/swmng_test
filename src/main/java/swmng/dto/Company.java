package swmng.dto;

public class Company {
	private int no;
	private String coName;
	private String address;
	private String tel;
	
/*	public Company(String coName, String address, String tel){
		this.coName = coName;
		this.address = address;
		this.tel = tel;
	}
	*/
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Company(int no, String coName, String address, String tel) {
		this.no = no;
		this.coName = coName;
		this.address = address;
		this.tel = tel;
	}
	public Company() {}

	public String[] toArray(){
		return new String [] {no+"",coName+"",address+"",tel+""};
		
	}
	
}
