/*Even though this class has fields, setters & getters, that are not used, they are here should
class be developed upon.*/
//Author: Daniel Magdziaarz

public class Account {

    private int accountNumber;
    private double accountBalance;
    private String customerName;
    private String email;
    private int phoneNumber;

    public void setAccountNumber(int accNumber){
        this.accountNumber = accNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void addAccountBalance(double deposit) {
        this.accountBalance += deposit;
    }

    public boolean withdrawAccountBalance(double amount) {
        boolean withdraw = this.accountBalance - amount >= 0 ? true : false;
        if(withdraw){
            this.accountBalance -= amount;
            return true;
        }
        return false;
    }

    public double showBalance(){
        return accountBalance;
    }

}
