import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogTransaction {
    String logFileName;
    public LogTransaction(String logFileName, Account account, double amount){
        this.logFileName = logFileName+".txt";

        LocalDateTime now = LocalDateTime.now();
        try{
            File file = new File(this.logFileName);
            file.createNewFile(); //creates if not present already
            System.out.println("---------------"+this.logFileName);

            FileWriter fw=new FileWriter(this.logFileName, true);
            fw.write("\n\nTransaction time  and date:"+now+"\n");
            fw.write("Account number "+account.getAccountNo()+"\n");
            if(amount!=0){
                if(amount>0){
                    fw.write("Added Amount :"+amount+"\n");
                    fw.write("Amount before Transaction :"
                            + (account.getAvailaibleAmount() - Math.abs(amount))
                            +"\n");
                }else if(amount<0){
                    fw.write("Withdrawn Amount :"+amount+"\n");
                    fw.write("Amount before Transaction :"
                            + (account.getAvailaibleAmount() + Math.abs(amount))
                            +"\n");
                }
                fw.write("Amount after Transaction :"+account.getAvailaibleAmount()+"\n");
                fw.write("Transaction Status : Successful "+"\n");
            }else {
                fw.write("Transaction Status : Failed "+"\n");
            }
            fw.write("The available amount in the account is :"+account.getAvailaibleAmount()+"\n");

            fw.close();
        }
        catch(IOException e){
            System.out.println("Logging error occurred");
            e.printStackTrace();
        }

    }
}
//* Every banking transaction should be saved in a file of each bank's transaction log
// which would have all details of the transaction like
// (time of transaction,account number,amount withdrawn,
// amount before deduction, amount after deduction,transaction status (can also be enum),
// failure reason if any)
