public class Person
{
    //attributes
    private String ID;
    private String name;
    private String address;
    private String contactNumber;
    
    //default constructor
    public Person(){
        ID=" ";
        name=" ";
        address=" ";
        contactNumber=" ";
    }
    
    //setter method
    public void setPerson(String staffID, String nm, String address, String cn) {
        this.ID = ID;
        name = nm;
        this.address = address;
        contactNumber = cn;
    }
    
    //normal constructor
    public Person(String ID, String name, String address, String contactNumber){
        this.ID=ID;
        this.name=name;
        this.address=address;
        this.contactNumber=contactNumber;
    }
    
    //retriever methods
    public String getName(){
        return name;
    } 
 
    public String getID(){
        return ID;
    }
 
    public String getAddress(){
        return address;
    }
 
    public String getContactNumber(){
        return contactNumber;
    }
    
    public String toString(){
        return("Name :............."+name
        +" \nID Number :........ " +ID
        +" \nAddress :.......... " +address
        +" \nContact Number :... " +contactNumber);
    }
}
