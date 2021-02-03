import java.util.Date;

public class VHS extends Video{

	public VHS(String title, int videoType, int priceCode, Date registeredDate) {
		super(title, videoType, priceCode, registeredDate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getLateReturnPointPenalty() {
		// TODO Auto-generated method stub
		return 1;
	}
}
