package assignment8;

import java.util.stream.Stream;

public class Customer extends Person{
    
    private int customerID;
    private double grosssales;
    private double data2[] = {customerID, grosssales};
    
    public Customer(int ID, double sales){
        
        super();
        this.customerID = ID;
        this.grosssales = sales;
        
    }
    
    protected Customer(){
        
    }
    
    public Customer(String s){
        
        copyCSV(s);
        
    }
    
    public int getID(){
        
        return this.customerID;
        
    }
    
    public double getGrossSales(){
        
        return this.grosssales;
        
    }
    
    public void setID(int ID){
        
        this.customerID = ID;
        
    }
    
    public void setSales(double sales){
        
        this.grosssales = sales;
        
    }
    
    public String convertToCSV() {
        return super.convertToCSV() + Stream.of(this.data2);
    }
    
    public void copy(Customer c){
        
        this.customerID = c.getID();
        this.grosssales = c.getGrossSales();
        
    }
    
    public void copy(int ID, double sales){
        
        this.customerID = ID;
        this.grosssales = sales;
        
    }
    
    public Customer clone(){
        
        Customer c1 = new Customer(this.customerID, this.grosssales);
        
        return c1;
        
    }
    
    public int compareTo(Customer a, Customer b){
        
        if(a.getID() < b.getID())
            return -1;
        else if (a.getID() > b.getID())
            return 1;
        else
            return 0;
        
    }
    
    public void copyCSV(String s){
        
        String split[];
        
        String delimiter = ",";
        
        split = s.split(delimiter);
        
        this.customerID = Integer.parseInt(split[0]);
        this.grosssales = Double.parseDouble(split[1]);
        
    }
    
    @Override
    public String toString(){
        
        
        return "CustomerID: " + this.customerID + 
             "\nGrossSales: " + this.grosssales + 
              "\n" + super.toString();
        
    }
    
}
