package CPPpack;

public class ProductPojo {
	
  private int pid;
  private int cid;
  private String pname;
  private String cname;  
  private float price;

  public int getPid() {
	return pid;
  }

  public float getPrice() {
	return price;
  }

  public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

public void setPrice(float price) {
	this.price = price;
  }

  public void setPid(int pid) {
	this.pid = pid;
  }
  public int getCid() {
 	return cid;
  }
  public void setCid(int cid) {
	this.cid = cid;
  }
  public String getPname() {
	return pname;
  }
  public void setPname(String pname) {
	this.pname = pname;
  }

}

