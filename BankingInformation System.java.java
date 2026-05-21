import java.util.*;

public class BankApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();
        User currentUser = null;

        while (true) {
            System.out.println("\n1.Register 2.Login 3.Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Username: ");
                    String uname = sc.next();
                    System.out.print("Password: ");
                    String pass = sc.next();
                    bank.register(uname, pass);
                    break;

                case 2:
                    System.out.print("Username: ");
                    uname = sc.next();
                    System.out.print("Password: ");
                    pass = sc.next();
                    currentUser = bank.login(uname, pass);

                    if (currentUser != null) {
                        System.out.println("Login Successful!");

                        while (true) {
                            System.out.println("\n1.Deposit 2.Withdraw 3.Transfer 4.Statement 5.Logout");
                            int opt = sc.nextInt();

                            try {
                                switch (opt) {

                                    case 1:
                                        System.out.print("Amount: ");
                                        double dep = sc.nextDouble();
                                        currentUser.getAccount().deposit(dep);
                                        break;

                                    case 2:
                                        System.out.print("Amount: ");
                                        double wit = sc.nextDouble();
                                        currentUser.getAccount().withdraw(wit);
                                        break;

                                    case 3:
                                        System.out.print("Receiver Username: ");
                                        String rec = sc.next();
                                        System.out.print("Amount: ");
                                        double amt = sc.nextDouble();
                                        bank.transfer(currentUser, rec, amt);
                                        break;

                                    case 4:
                                        currentUser.getAccount().printStatement();
                                        break;

                                    case 5:
                                        currentUser = null;
                                        break;

                                    default:
                                        System.out.println("Invalid Option!");
                                }

                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                            }

                            if (currentUser == null)
                                break;
                        }

                    } else {
                        System.out.println("Invalid Credentials!");
                    }
                    break;

                case 3:
                    sc.close();   // Scanner close
                    System.out.println("Thank you for using the Bank App.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}