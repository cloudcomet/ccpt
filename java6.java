class Bank{
    private int bal;
    Bank(){
        this.bal=2000;
    }
    public int getBal(){
        return bal;
    }
    public int deposit(int amt){
        bal+=amt;
        return amt;//bal;
    }
    public int withdraw(int amt){
        if(amt>0 && amt<=bal)
            bal-=amt;
        return amt;//bal;
    }

}
public class java6 {
    public static void main(String[] args) {
        Bank b=new Bank();
        //System.out.println("Initial Balance: "+b.getBal());
        System.out.println("Balance after depositing 500: "+b.deposit(500));
        System.out.println("Balance after withdrawing 300: "+b.withdraw(300));
        System.out.println(b.getBal());
    }
    
}
