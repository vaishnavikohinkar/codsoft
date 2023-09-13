import java.util.Scanner;

public class AccountBank 
    {

	private double balance;
	
	public AccountBank(double initialBalance)  {
		
		this.balance = initialBalance;
	}
	
	public double getBalance()  {
		return balance;
		
	}
	public void deposit(double amount)  {
		balance +=amount;
		
	}
	
		public boolean withdraw (double amount)  {
			
			if (amount <= balance)  {
				balance -= amount;
				return true;                   //withdraw successful
				
			}
		        return false;                  // insufficient balance
		}
    }

class ATM   {
      private AccountBank accountBank;
      private Scanner scanner;
      
      public ATM(AccountBank accountBank)   {
    	 this.accountBank = accountBank;
    	 this.scanner = new Scanner(System.in);
    	 
      }
      
      public void displayMenu()  {
    	  System.out.println("Welcome to the ATM");
    	  System.out.println("1. Withdraw");
    	  System.out.println("2. Deposit");
    	  System.out.println("3. Check Balance");
    	  System.out.println("4. Exit");
    	  System.out.println("Enter your Choice: ");
    	  
    	  
      }
      
      public void performTransaction()  {
    	  while (true)    {
    		  displayMenu();
    		  int choice = scanner.nextInt();
    		  
    		  switch (choice)   {
    		  case 1:
    			  System.out.println("Enter the amount to withdraw: ");
    			  double withdrawAmount = scanner.nextDouble();
    			  
    			  //validate input
    			  if (withdrawAmount <= 0)  {
    				  System.out.println("Invalid amount.please enter a positive value.");
    				  break;
    			  }
    			  
    			  boolean withdrawalSuccess = accountBank.withdraw(withdrawAmount);
    			  if (withdrawalSuccess)   {
    				  System.out.println("withdrawal successful.please take your cash.");
    			  }
    			  
    			  else {
    				 System.out.println("Insufficient balance.Unable to process withdrawal.");
    				  
    			  }
    			  
    			  break;
    			  
    		  case 2:
    			  System.out.print("Enter the amount to deposit : ");
    			  double depositAmount = scanner.nextDouble();
    			  
    			  
    			  //validate input
    			  if (depositAmount <= 0)  {
    				  System.out.println("Invalid amount.please enter a positive value.");
    				  break;
    			  }
    			  
    			  accountBank.deposit(depositAmount);
    			  System.out.println("Deposit successful.Thank you for using our services.");
    			  break;
    			  
    		  case 3:
    			  double balance = accountBank.getBalance();
    			  System.out.println("your account balance is: " +balance);
    			  break;
    			  
    		  case 4:
    			  System.out.println("Thank you for using the ATM.Goodbye!");
    			  return;
    			  
    			  
    			  default:
    				  System.out.println("Invalid choice.please try again.");
    		  }
    	  }
      }
      
      
      
      
      
      public class ATM_main  {
    	  public static void main(String[] args)   {
    		  AccountBank accountBank = new AccountBank(500.0);  //Initialize with an initial balance 
    		  ATM atm = new ATM(accountBank);
    		  atm.performTransaction();
    		  
    		  
    	  }
      }
      
    		  
}

    		  
    		  
    		  
    		  
    		  

    	  
    			  
    			  
    			  
    		  
    	 
    	 
      
	
	
		// TODO Auto-generated method stub

	


