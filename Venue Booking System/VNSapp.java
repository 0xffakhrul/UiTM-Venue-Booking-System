import java.lang.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
public class VNSapp
{
    private static DecimalFormat d2 = new DecimalFormat("#.##");
    private static DecimalFormat d1 = new DecimalFormat("#.00");
    public static void main(String args[]){
        Booking [] booking = new Booking[20]; //declaration for array of object booking
        
        Scanner inputText=new Scanner(System.in);
        Scanner inputNum=new Scanner(System.in);
        
        String name, id, address, number, eventName, date, startTime, endTime, venueName;
        int  countDT=0, countDK3=0, countDK2=0;
        double charge=0,usageFullHour, usageHour,usageMinute, totalCollection=0;
        
        
        Person person = new Person();
        Event event = new Event();
        
        char choice='A';

        for(int i=0; i<20;i++){
            if(Character.toUpperCase(choice)=='A'){
                //input all the requires informations
                System.out.println("**************************************** " );
                System.out.println("\nUiTM's VENUES BOOKING SYSTEM " );
                System.out.println("\n**************************************** " );
                System.out.println("Booking "+(i+1));
                System.out.println("Enter the following info...  ");
                System.out.print("\nName : ");
                name=inputText.nextLine();
                System.out.print("NRIC/Staff ID/Student ID : ");
                id=inputText.nextLine();
                System.out.print("Address : ");
                address=inputText.nextLine();
                System.out.print("Contact Number : ");
                number=inputText.nextLine();
                System.out.print("Event name : ");
                eventName=inputText.nextLine();
                System.out.print("Venue (DT|DK300|DK200) : ");
                venueName=inputText.nextLine();
                System.out.print("Date (DD/MM/YYYY) : ");
                date=inputText.nextLine();
                System.out.print("Time Start(24 hours) : ");
                startTime=inputText.nextLine();
                System.out.print("Time Ended(24 hours) : ");
                endTime=inputText.nextLine();
                
                //invoke default constructor and setter method for object booking
                booking[i]= new Booking();
                booking[i].setBooking(new Event(eventName, date, startTime, endTime, new Person(id, name, address, number),new Venue(venueName)));
                
                //set attribute usage time
                usageHour=booking[i].event.calcUsageHour(startTime, endTime);
                booking[i].event.setUsageHour(usageHour);
                usageMinute=booking[i].event.calcUsageMinute(startTime, endTime);
                booking[i].event.setUsageMinute(usageMinute);
                
                //initialize the usage hour using the calcUsageHour method
                usageFullHour = booking[i].getEvent().calcUsageFullHour(startTime, endTime);

                //calculate the charge based on the category
                //if(booking[i].getEvent().getPerson().getID().length()==6 || booking[i].getEvent().getPerson().getID().length()==10)
                if (id.length()==6 || id.length()==10)
                    charge=0;
                else
                    charge = booking[i].getEvent().calcCharge(usageFullHour);
                
                //test output duration n charge
                System.out.println("\nUsage Hour : " +d2.format(booking[i].event.usageHour)+" hours and "+d2.format(booking[i].event.usageMinute)+" minutes" );    
                System.out.println("Charge : RM " +d1.format(charge)+"\n");
                
                booking[i].displayReceipt();
                
                if(booking[i].event.getVenue().equalsIgnoreCase("DT"))
                    countDT++;
                else if(booking[i].event.getVenue().equalsIgnoreCase("DK300"))
                    countDK3++;
                else
                    countDK2++;
                
                totalCollection=totalCollection+charge;
                
                System.out.println("\n[A] Booking | [B] Exit");
                System.out.print("Enter your choice (A/B) :");
                choice = inputText.nextLine().charAt(0);
            }
            else
                break;
                //Staff id = 6
                //student = 10
                //ic = 12
        }
        //test count
        System.out.println("\nTotal Booking : ");
        System.out.println("Dewan Titiwangsa : " + countDT);
        System.out.println("Dewan Kuliah 300 : " + countDK3);
        System.out.println("Dewan Kuliah 200 : " + countDK2);
        System.out.println("Total collection for all booking(s) is RM "+d1.format(totalCollection));
    }
}
