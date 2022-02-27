public class Account {
    private Bank bank;
    private final Customer customer;
    private final long accountNo;
    private double amount=0.0;
    private static final double amountLimit=500000.0;
    String logFileName;

    static long lastGeneratedAccountNo;

    public Account(Customer customer, Bank b, double initialAmt){
        this.bank = b;
        //runtime polymorphism
        if(b instanceof SBI){
            this.logFileName = ((SBI)b).bankName;
        }else if(bank instanceof BOI){
            this.logFileName = ((BOI)b).bankName;
        }else if(bank instanceof ICICI){
            this.logFileName = ((ICICI)b).bankName;
        }
        this.customer = customer;
        this.amount = initialAmt;
        this.accountNo = generateNewAccountNo();
    }
    public double addMoney(double addAmt){
        addAmt = Math.abs(addAmt); //no negatives allowed
        if(addAmt<amountLimit){
            this.amount += addAmt;
            System.out.println("Amount "+addAmt+" added successfully\n");
            new LogTransaction(this.logFileName, this, addAmt);

        }else{
            System.out.println("Could not add money to the account\n");
            new LogTransaction(this.logFileName, this, 0);

        }
        return this.amount;
    }
    public double withdrawMoney(double withdrawAmt) throws InsufficientAmountException{
        withdrawAmt = -1 * Math.abs(withdrawAmt); //amount to be deduced hence negative.

        if(this.amount+withdrawAmt>=0){
            this.amount += withdrawAmt;
            System.out.println("Amount "+Math.abs(withdrawAmt)+" withdrawn successfully\n");
            new LogTransaction(this.logFileName, this,  -1 * Math.abs(withdrawAmt));
        }else{
            new LogTransaction(this.logFileName, this, 0);
            throw new InsufficientAmountException();
        }

        return this.amount;
    }

    public void printAccountDetails(){
        this.bank.printBankDetails();
        this.customer.printCustomerDetails();

        System.out.println("Account Details : \n"
                +"Account No is "+this.accountNo
                +" Available Amount in the Account is "+this.amount
        );
    }
    public long getAccountNo(){
        return this.accountNo;
    }
    public double getAvailaibleAmount(){
        return this.amount;
    }
    private long generateNewAccountNo(){
        return ++lastGeneratedAccountNo;
    }
}
