import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUIControl {
    static Scanner scanner = new Scanner(System.in) ;
    List<Customer> customers = new ArrayList<Customer>();
    List<Video> videos = new ArrayList<Video>();

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public void removeCustomer(Customer c) {
        customers.remove(c);
    }

    public void addVideo(Video c) {
        videos.add(c);
    }

    public void removeVideo(Video c) {
        videos.remove(c);
    }

    public void clearRentals() {
        String customerName = inputCustomerName();

        Customer foundCustomer = null ;
        for ( Customer customer: this.customers) {
            if ( customer.getName().equals(customerName)) {
                foundCustomer = customer ;
                break ;
            }
        }

        if ( foundCustomer == null ) {
            System.out.println("No customer found") ;
        } else {
            System.out.println("Name: " + foundCustomer.getName() +
                    "\tRentals: " + foundCustomer.getRentals().size()) ;
            for ( Rental rental: foundCustomer.getRentals() ) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
            }

            List<Rental> rentals = new ArrayList<Rental>() ;
            foundCustomer.setRentals(rentals);
        }
    }

    public void returnVideo() {
        Customer foundCustomer = getCustomer();
        if (foundCustomer == null) return;

        System.out.println("Enter video title to return: ") ;
        String videoTitle = this.scanner.next() ;

        List<Rental> customerRentals = foundCustomer.getRentals() ;
        for ( Rental rental: customerRentals ) {
            if ( rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented() ) {
                rental.returnVideo();
                rental.getVideo().setRented(false);
                break ;
            }
        }
    }

    protected void init() {
        Customer james = new Customer("James")
        addCustomer(new Customer("James"));
        addCustomer(new Customer("Brown"));

        Video v1 = new Video("v1", Video.CD, Video.REGULAR, new Date()) ;
        Video v2 = new Video("v2", Video.DVD, Video.NEW_RELEASE, new Date()) ;

        addVideo(v1) ;
        addVideo(v2) ;

        // @tsshin: Video/Rental class 정리 후 변경 필요
        james.addRental(new Rental(v1)) ;
        james.addRental(new Rental(v2)) ;
    }

    public void listVideos() {
        System.out.println("List of videos");

        for ( Video video: this.videos) {
            System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
        }
        System.out.println("End of list");
    }

    public void listCustomers() {
        System.out.println("List of customers");
        for ( Customer customer: this.customers) {
            System.out.println("Name: " + customer.getName() +
                    "\tRentals: " + customer.getRentals().size()) ;
            for ( Rental rental: customer.getRentals() ) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
            }
        }
        System.out.println("End of list");
    }

    public void getCustomerReport() {
        Customer foundCustomer = getCustomer();

        if ( foundCustomer == null ) {
            System.out.println("No customer found") ;
        } else {
            String result = foundCustomer.getReport() ;
            System.out.println(result);
        }
    }

    public void rentVideo() {
        Customer foundCustomer = getCustomer();
        if (foundCustomer == null) return;

        System.out.println("Enter video title to rent: ") ;
        String videoTitle = this.scanner.next() ;

        Video foundVideo = null ;
        for ( Video video: this.videos) {
            if ( video.getTitle().equals(videoTitle) && video.isRented() == false ) {
                foundVideo = video ;
                break ;
            }
        }

        if ( foundVideo == null ) return ;

        Rental rental = new Rental(foundVideo) ;
        foundVideo.setRented(true);

        List<Rental> customerRentals = foundCustomer.getRentals() ;
        customerRentals.add(rental);
        foundCustomer.setRentals(customerRentals);
    }

    public void register(String object) {
        if ( object.equals("customer") ) {
            String name = inputCustomerName();
            addCustomer(new Customer(name));
        }
        else {
            System.out.println("Enter video title to register: ") ;
            String title = this.scanner.next() ;

            System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
            int videoType = this.scanner.nextInt();

            System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
            int priceCode = this.scanner.nextInt();

            addVideo(new Video(title, videoType, priceCode, new Date()));
        }
    }

    private String inputCustomerName() {
        System.out.println("Enter customer name: ") ;
        return this.scanner.next();
    }

    private Customer getCustomer() {
        String customerName = inputCustomerName();

        Customer foundCustomer = null ;
        for ( Customer customer: this.customers) {
            if ( customer.getName().equals(customerName)) {
                foundCustomer = customer ;
                break ;
            }
        }
        if ( foundCustomer == null ) return null;
        return foundCustomer;
    }

    public int showCommand() {
        System.out.println("\nSelect a command !");
        System.out.println("\t 0. Quit");
        System.out.println("\t 1. List customers");
        System.out.println("\t 2. List videos");
        System.out.println("\t 3. Register customer");
        System.out.println("\t 4. Register video");
        System.out.println("\t 5. Rent video");
        System.out.println("\t 6. Return video");
        System.out.println("\t 7. Show customer report");
        System.out.println("\t 8. Show customer and clear rentals");

        int command = this.scanner.nextInt() ;

        return command ;

    }
}
