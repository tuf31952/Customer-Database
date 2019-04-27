
package assignment8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {
    
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    
    public Person(String firstname, String lastname, String address, String city, String state, String zipcode){
        
        this.firstName = firstname;
        this.lastName = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipcode;
        
    }
    
    protected Person(){
        
        
    }
    
    public String getfirstname(){
        
        return this.firstName;
    }
    
    public String getlastname(){
        
        return this.lastName;
    }
    
    public String getaddress(){
        
        return this.address;
    }
    
    public String getcity(){
        
        return this.city;
    }
    
    public String getstate(){
        
        return this.state;
    }
    
    public String getZipcode(){
        
        return this.zipCode;
    }
    
    public void setFirstName(String firstname) {
    
        this.firstName = firstname;
    
    }
    
    public void setLastName(String lastname) {
    
        this.lastName = lastname;
    
    }
    
    public void setAddress(String address) {
    
        this.address = address;
    
    }
    
    public void setCity(String city) {
    
        this.city = city;
    
    }
    
    public void setState(String state) {
    
        this.state = state;
    
    }
    
    public void setZipCode(String zipcode) {
    
        this.zipCode = zipcode;
    
    }
    
    public String convertToCSV() {
        
        return this.firstName+","+this.lastName+","+this.address+","+this.city+","+this.state+","+this.zipCode+",";
    }
    
    public void copy(String firstname, String lastname, String address, String city, String state, String zipcode){
        
        this.firstName = firstname;
        this.lastName = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipcode;
        
    }
    
    public Person clone(){
       
       Person p1 = new Person(this.firstName, this.lastName, this.address, this.city, this.state, this.zipCode);
       
       return p1;
       
        
    }
    
    @Override
    public String toString(){
        
        return  "First Name: " + this.firstName + 
               "\nLast Name: " + this.lastName + 
               "\nAddress:   " + this.address + 
               "\nCity:      " + this.city +  
               "\nState:     " + this.state +
               "\nZipCode:   " + this.zipCode + "\n\n";
        
    }
    
    
}
