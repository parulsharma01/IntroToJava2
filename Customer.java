public class Customer {
    private String name;
    private String address;
    private String phoneNo;

    public Customer(String name,String address, String phoneNo){
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }
    public void printCustomerDetails(){
        System.out.println("Customer Details : \n"
                +"Customer Name is "+this.name
                +" Address is "+this.address
                +" Phone no. is "+this.phoneNo
        );
    }
}
