import java.util.Date;

public class Rental {
	public static final int DAY_IN_MILLI_SEC = 1000 * 60 * 60 * 24;
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;
	private String rentalInfo ;
	private double charge;
	private int point;

	public Rental(Video video) {
		this.video = video ;
		status = 0 ;
		rentDate = new Date() ;
	}
	
	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == 1 ) {
			this.status = 1;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
	
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	public int getDaysRented() {
		long returnDateMilliSec = 0L;
		if (getStatus() == 1) { // returned Video
			returnDateMilliSec = returnDate.getTime();
		} else { // not yet returned
			returnDateMilliSec = new Date().getTime();
		}
		long diff = returnDateMilliSec - rentDate.getTime();
		return (int) (diff / DAY_IN_MILLI_SEC) + 1;
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		if ( getDaysRented() <= 2) return limit ;
		switch ( video.getVideoType() ) {
			case Video.VHS: limit = 5 ; break ;
			case Video.CD: limit = 3 ; break ;
			case Video.DVD: limit = 2 ; break ;
		}
		return limit ;	
	}
	
	public String getRentalInfo() {
		return rentalInfo;
	}
	
	public void makeRentalInfo() {
		double tempCharge = 0;
		int tempPoint = 0 ;
		int daysRented = getDaysRented();

		switch (getVideo().getPriceCode()) {
		case Video.REGULAR:
			tempCharge += 2;
			if (daysRented > 2)
				tempCharge += (daysRented - 2) * 1.5;
			break;
		case Video.NEW_RELEASE:
			tempCharge = daysRented * 3;
			break;
		}

		tempPoint++;
		
		if ((getVideo().getPriceCode() == Video.NEW_RELEASE) )
			tempPoint++;
		
		if ( daysRented > getDaysRentedLimit() )
			tempPoint -= Math.min(tempPoint, getVideo().getLateReturnPointPenalty()) ;
		
		String result = "\t" + getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + tempCharge
				+ "\tPoint: " + tempPoint + "\n";
		
		setRentalInfo(result);
		setCharge(tempCharge);
		setPoint(tempPoint);
	}

	public void setRentalInfo(String rentalInfo) {
		this.rentalInfo = rentalInfo;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}