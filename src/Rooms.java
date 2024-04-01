import java.util.ArrayList;

public class Rooms {
   private String roomNumber;
   private double bill;
   private int customerCount;

    //Oda müsaitlik durumları
   public enum Status {
       available,
       nonavailable
   }
   Status s;

   //Oda Tipleri
   public enum Types{
       economic,
       normal,
       suit
   }
   Types type;

   //Müşteriler arraylisti oluşturuldu.
   private ArrayList<Customer> customers ;

   public Rooms(String roomNumber,double bill, int customerCount){

       this.roomNumber = roomNumber;
       this.bill = bill;
       this.customerCount=customerCount;

       customers = new ArrayList<>(customerCount);

       for(int i = 0 ; i < customerCount;i++){
           customers.add(new Customer());
       }
       this.s = Status.available;
   }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    public Status getS() {
        return s;
    }

    public void setS(Status s) {
        this.s = s;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber + " Type: " + type + " status: " + s + " bill: " + bill;
    }

    public void displayCustomers(){
       for(Customer c : customers){
           System.out.println(c);
       }
    }
}
