import java.util.Date;

public class RentalItemFactory {

	public Video createVideo(String title, int videoType, int priceCode)
	{
		Video video = null;
				
		if (title.equals("DVD"))
		{
			video = new DVD(title, videoType, new Date());	
		}
		else if (title.equals("CD"))
		{
			video = new CD(title, videoType, new Date());
		}
		else if (title.equals("VHS"))
		{
			video = new VHS(title, videoType, new Date());
		}
		
		return video;
	}
}
