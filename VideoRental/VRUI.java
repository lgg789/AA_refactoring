
public class VRUI {
	private static VRUIControl ctrl = new VRUIControl();
	public static void main(String[] args) {
		//for testing
		ctrl.init();

		boolean quit = false ;
		while ( ! quit ) {
			int command = ctrl.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ctrl.listCustomers() ; break ;
				case 2: ctrl.listVideos() ; break ;
				case 3: ctrl.register("customer") ; break ;
				case 4: ctrl.register("video") ; break ;
				case 5: ctrl.rentVideo() ; break ;
				case 6: ctrl.returnVideo() ; break ;
				case 7: ctrl.getCustomerReport() ; break;
				case 8: ctrl.clearRentals() ; break ;
				case -1: ctrl.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

}
