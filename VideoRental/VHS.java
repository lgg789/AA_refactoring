import java.util.Date;

public class VHS extends Video{

	public VHS(String title, int priceCode, Date registeredDate) {
		super(title, priceCode, registeredDate);
		setLimit(5);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getLateReturnPointPenalty() {
		// TODO Auto-generated method stub
		return 1;
	}

}
