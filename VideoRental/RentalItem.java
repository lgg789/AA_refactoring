import java.util.Date;


public abstract class RentalItem {

	private String title;
	private int priceCode;
	public static final int REGULAR = 1;
	public static final int NEW_RELEASE = 2;
	
	protected Date registeredDate;
	private boolean rented;

	public RentalItem() {
		super();
	}

	public abstract int getLateReturnPointPenalty();	

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
}