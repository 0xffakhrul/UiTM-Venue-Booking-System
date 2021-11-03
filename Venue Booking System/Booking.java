
public class Booking
{
    public Event event;
    
    public Booking(){
        event = new Event();
    }
    
    public void setBooking(Event event){
        this.event = event;
    }
    
    public Event getEvent(){return event;}
    
    public void displayReceipt(){
        System.out.println("Booking details: ");
        System.out.println("\nPerson in charge details: ");
        System.out.println(event.getPerson().toString());
        System.out.println("\nEvent and venue details: ");
        System.out.println(event.toString());
    }
}

