import java.util.Arrays; 
import java.text.DecimalFormat;
public class Event
{
    private static DecimalFormat d2 = new DecimalFormat("#.##");
    //attributes/data member
    private String eventName;
    private String date;
    private String timeStart;
    private String timeEnd;
    private Person person;
    public Venue venue;
    public double usageHour;
    public double usageMinute;
    public double usageFullHour;
    
    //default constructor
    public Event(){
            eventName = " ";
            date = " "; 
            timeStart = "0000";
            timeEnd = "0000";
            person = new Person();
            venue =  new Venue();
    }
    
    //setter
    public void setEvent(String en, String dt, String timeStart, String timeEnd, Person person, Venue venue ){
        eventName= en;
        date=dt;
        this.timeStart=timeStart;
        this.timeEnd=timeEnd;
        this.person = person;
        this.venue=venue;
    }
    
    public Event(String en, String dt, String timeStart, String timeEnd, Person person, Venue venue ){
        eventName= en;
        date=dt;
        this.timeStart=timeStart;
        this.timeEnd=timeEnd;
        this.person = person;
        this.venue=venue;
    }
    
    public void setUsageHour(double usageHour)
    {
        this.usageHour=usageHour;
    }
    
    public void setUsageMinute(double usageMinute)
    {
        this.usageMinute=usageMinute;
    }
    //retrievers
    public String getEventName(){
        return eventName;}
    public String getDate(){
        return date;}
    public String getTimeStart(){
        return timeStart;}
    public String getTimeEnd(){
        return timeEnd;}
    public Person getPerson(){
        return person;}
    public String getVenue(){
        return venue.getVenue();}
    
    public double calcUsageFullHour(String timeStart, String timeEnd){
        double hourStart, hourEnd, minuteStart, minuteEnd, usageHour,usageMinute,usageFullHour;;
        
        hourStart=Integer.parseInt(timeStart.substring(0,2));
        hourEnd=Integer.parseInt(timeEnd.substring(0,2));
        minuteStart=Integer.parseInt(timeStart.substring(2,4));
        minuteEnd=Integer.parseInt(timeEnd.substring(2,4));
 
        usageHour= hourEnd-hourStart;
        usageMinute= minuteEnd-minuteStart;
 
        if(usageMinute<0){
            usageHour=usageHour-1;
            usageMinute=usageMinute+60;
        }
        
        usageFullHour=usageHour+(usageMinute/60);
        return usageFullHour;
    }
    
    public double calcUsageHour(String timeStart, String timeEnd){
        double hourStart, hourEnd, minuteStart, minuteEnd, usageHour,usageMinute;
        
        hourStart=Integer.parseInt(timeStart.substring(0,2));
        hourEnd=Integer.parseInt(timeEnd.substring(0,2));
        minuteStart=Integer.parseInt(timeStart.substring(2,4));
        minuteEnd=Integer.parseInt(timeEnd.substring(2,4));
 
        usageHour= hourEnd-hourStart;
        usageMinute= minuteEnd-minuteStart;
 
        if(usageMinute<0){
            usageHour=usageHour-1;
            usageMinute=usageMinute+60;
        }
        
        return usageHour;
    }
    
    public double calcUsageMinute(String timeStart, String timeEnd){
        double hourStart, hourEnd, minuteStart, minuteEnd, usageHour,usageMinute;
        
        hourStart=Integer.parseInt(timeStart.substring(0,2));
        hourEnd=Integer.parseInt(timeEnd.substring(0,2));
        minuteStart=Integer.parseInt(timeStart.substring(2,4));
        minuteEnd=Integer.parseInt(timeEnd.substring(2,4));
 
        usageHour= hourEnd-hourStart;
        usageMinute= minuteEnd-minuteStart;
 
        if(usageMinute<0){
            usageHour=usageHour-1;
            usageMinute=usageMinute+60;
        }
        
        return usageMinute;
    }
    
    public double calcCharge(double fullHour){
        double charge=0;
        if(venue.getVenue().equalsIgnoreCase("DT"))
            charge = fullHour*300;
        
        else if(venue.getVenue().equalsIgnoreCase("DK300"))
            charge = fullHour*150;
        
        else
            charge = fullHour*100;
            
        return charge;
    }
    
    public String toString(){
        if(usageMinute==0)
        {
            return("Event Name :..................... " +eventName
            +" \nVenue :.......................... "+venue.getVenue()
            +" \nDate :........................... "+date
            +" \nBooking time ( starting ) :...... " +timeStart
            +" \nBooking time ( ending ) :........ " +timeEnd
            +" \nUsage hour : .................... " +d2.format(usageHour)+" hours");
        }
        else 
        {
            return("Event Name :..................... " +eventName
            +" \nVenue :.......................... "+venue.getVenue()
            +" \nDate :........................... "+date
            +" \nBooking time ( starting ) :...... " +timeStart
            +" \nBooking time ( ending ) :........ " +timeEnd
            +" \nUsage hour : .................... " +d2.format(usageHour)+" hours and "+d2.format(usageMinute)+" minutes.");
        }
    }
}
