package book.source;


import java.io.Serializable;

public class Customer implements Serializable{
	private int id ;
	private String name;
	private String addr;
	private String phone;

	public Customer(int id, String name, String addr, String phone) {

		this.id = id;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	@Override
	public String toString(){
		return "Customer[" + id + "," + name + ", " + addr+", " + phone+"]";
		
	}
	
}

