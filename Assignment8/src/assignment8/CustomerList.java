
package assignment8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CustomerList extends Customer{
    
    int size;
    Customer arr[] = new Customer[size];
    
    public CustomerList(){
        
        this.size = 4;
        
    }
    
    public int size(){
        
        return this.size;
    
    }
    
    public Customer get(int i){
        
        return arr[i];
        
    }
    
    public boolean set(Customer c, int i){
        
        if (i < arr.length){
            arr[i] = c;
            return true;
        }
        else
            return false;
        
    }
    
    public void add(Customer c){
        
        this.size += 1;
        this.arr[arr.length - 1] = c;
        if (this.arr.length == this.size){
            
            Customer temparr[] = new Customer[size*2];
            
            for(int i = 0; i<arr.length; i++){
                
                temparr[i] = arr[i];
                
            }
            
            this.arr = temparr;
            
        }
        
        
    }
    
    public Customer remove(int i){
        
        if (i>this.arr.length){
            
            return null;
            
        } else{
            Customer temp = this.arr[i];
            this.arr[i] = null;
            for (int j = i; j<this.arr.length - 1; j++){
                this.arr[j] = this.arr[j+1];
            }
            return temp;
        }
    }
    
    @Override
    public String toString(){
        
        double totalsales = 0;
        String result = "\n";
        
        for (int i = 0; i<arr.length; i++){
            
            result = result +  arr[i].toString();
            totalsales = totalsales + arr[i].getGrossSales();
            
        }
        
        return result + "\nTotal Sales: " + totalsales;
        
    }
    
    public static CustomerList read(String fn){
        
        CustomerList clist = new CustomerList();
        
        File file = new File(fn);
        
        try {
            Scanner inputStream= new Scanner(file);

            while(inputStream.hasNext()){
                String data= inputStream.next();
                Customer c1 = new Customer(data);
                clist.add(c1);
        }
            inputStream.close();
            
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        
        return clist;
        
    }
    
    public static boolean write(CustomerList cl, String fn) throws FileNotFoundException{
        
        try (PrintWriter writer = new PrintWriter(new File(fn))){
            
            for (int i = 0; i<cl.size(); i++){
                
                writer.write(cl.get(i).convertToCSV());
                
            }
            
            return true;
         
         } catch (FileNotFoundException e) {
                return false;
        }
        
    }
    
    public void sort(){
        
        
        Arrays.sort(this.arr);
        
    }
    
    
    public int indexOf(int id){
        
        int min = 0;
        int max = this.arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (this.arr[mid].getID() < id) {
            min = mid + 1;
            } else if (this.arr[mid].getID() > id) {
            max = mid - 1;
            } else {
            return mid;
            }
        }
        
        return -(min + 1);
        
    }
    
    public boolean update(int id, double grossales){
        
        int location = indexOf(id);
        
        if (location>=1){
        
            this.arr[location].setSales(this.arr[location].getGrossSales() + grossales);
        
            return true;
        
        } else
            return false;
        
    }
    
}