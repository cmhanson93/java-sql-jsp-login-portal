package logindb;

public class Item {
	
	public int serialNum;	public int getSerialNum(){ return this.serialNum;}	public void setSerialNum(int serialNum){ this.serialNum = serialNum;}
	public String type; 	public String getType() { return this.type;}		public void setType(String type){ this.type = type;}
	public String title; 	public String getTitle() { return this.title;}		public void setTitle(String title){ this.title = title;}
	public double price; 	public double getPrice(){ return this.price;}		public void setPrice(double price){ this.price = price;}
	
	
	//:D
	public Item()
	{
		;
	}
	public Item(int serialNum, String type, String title, double price)
	{
		this.serialNum = serialNum;
		this.type = type;
		this.title = title;
		this.price = price;
	}

}
