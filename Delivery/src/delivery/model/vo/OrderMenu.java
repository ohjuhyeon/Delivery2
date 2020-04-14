package delivery.model.vo;

import java.sql.Date;

public class OrderMenu {

	private Date orderDate;
	private int orderNo;
	private int orderAmount;
	private int menuNo;
	private String cusId;
	private String strId;
	private String delivery;
	private int priceSum;

	public OrderMenu() {
	}

	public OrderMenu(Date orderDate, int orderNo, int orderAmount, int menuNo, String cusId, String strId,
			String delivery, int priceSum) {
		super();
		this.orderDate = orderDate;
		this.orderNo = orderNo;
		this.orderAmount = orderAmount;
		this.menuNo = menuNo;
		this.cusId = cusId;
		this.strId = strId;
		this.delivery = delivery;
		this.priceSum = priceSum;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getStrId() {
		return strId;
	}

	public void setStrId(String strId) {
		this.strId = strId;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public int getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(int priceSum) {
		this.priceSum = priceSum;
	}

	@Override
	public String toString() {
		return this.orderNo + ", " + this.orderDate + ", " + this.cusId + ", " + this.priceSum + ", " + this.orderAmount
				+ ", " + this.delivery + ", ";
	}

	public String printString() {

		return this.orderDate + ", " + this.priceSum;

	}

}
