package beta2;

public class ItemBean {
private int ItemPay_no;
private String ItemPay_title;
private double ItemPay_rate;
private double ItemPay_amount;

public int getItemPay_no() {
	return ItemPay_no;
}
public void setItemPay_no(int itemPay_no) {
	ItemPay_no = itemPay_no;
}
public String getItemPay_title() {
	return ItemPay_title;
}
public void setItemPay_title(String itemPay_title) {
	ItemPay_title = itemPay_title;
}
public double getItemPay_rate() {
	return ItemPay_rate;
}
public void setItemPay_rate(double itemPay_rate) {
	ItemPay_rate = itemPay_rate;
}

public void setItemPay_amount(double itemPay_amount){
	this.ItemPay_amount=itemPay_amount;
}

public double getItemPay_amount(){
	return this.ItemPay_amount;
}

}
