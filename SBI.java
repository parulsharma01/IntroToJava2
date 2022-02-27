public class SBI extends Bank{
    String bankName = "SBI";
    double rateOfInterest = 10;
    String bankType; //savings or current

    public SBI(type bankType){
        this.bankType = String.valueOf(bankType);
    }

    @Override
    public String getBankDetails() {
        String details = "";
        details += "Bank name : " +this.bankName +"\n";
        details += "Rate of Interest : " +this.rateOfInterest +"\n";
        details += "Bank type : " +this.bankType +"\n";
        return details;
    }
}
