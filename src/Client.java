import java.util.*;
public class Client {
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAdsence() {
        return adsence;
    }

    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    private String name;
   private String surname;
   private String adsence;
   private long id;
   private double balance;
   private String password;
   public Client (String name, String surname, String adsence, long id, double balance, String password) {
       this.name = name;
       this.surname = surname;
       this.adsence = adsence;
       this.id = id;
       this.balance = balance;
       this.password = password;
   }
   public void replenish () {

   }
   public void consumption () {

   }
   public void request_balance () {
       System.out.println(balance);
   }
   public void update () {
        System.out.println(balance);
    }

}
