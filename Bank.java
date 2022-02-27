public abstract class Bank{
    public String bankName = "Bank";
    public double rateOfInterest = 0;
    public enum type{SAVINGS, CURRENT};

    public String getBankDetails() {
        String details = "";
        details += "Bank name : " +this.bankName +"\n";
        details += "Rate of Interest : " +this.rateOfInterest +"\n";
        return details;
    }
    public void printBankDetails(){
        System.out.println("Bank Details : \n" + getBankDetails());
    }
}
/*
*
-getDetails which provide their specific details like rateofinterest etc
- printDetails of every bank.
- Every bank account should have a type (enum): SAVINGS, CURRENT
* */