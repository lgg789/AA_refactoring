import java.util.Date;

public class RentalItemFactory {

	public Video createVideo(String title, int videoType, int priceCode)
	{
		Video video = null;
		
		/*1 for VHD, 2 for CD, 3 for DVD*/
		switch (videoType)
		{
		case 1:
			video = new VHS(title, priceCode, new Date());			
			break;
		case 2:
			video = new CD(title, priceCode, new Date());
			break;		
		case 3:
			video = new DVD(title, priceCode, new Date());
			break;
		}
		
		return video;
	}
}
