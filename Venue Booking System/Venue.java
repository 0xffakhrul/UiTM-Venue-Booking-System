import java.util.Arrays;
public class Venue
{
    //data member
    private String venue;
    
    //default constructor 
    public Venue(){
        venue="";
    }
    
    //normal constructor
    public Venue(String venue){
        this.venue=venue;
    }
    
    //setter method
    public void setVenue(String venue){
        this.venue=venue;
    }
    
    //retriever method
    public String getVenue(){
        return venue;}
}
