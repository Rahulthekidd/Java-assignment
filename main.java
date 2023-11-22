package Pkg;

import java.sql.SQLException;
import java.util.Scanner;

public class Con_2 {

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
        // Main File
        @SuppressWarnings("null")
        int i = 1;
        // Calling Scanner class Via object
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        // Calling Con_class Via object
        Con_class call = new Con_class();

        call.WelcomeA();

        // Calling the Reg_Drivermysql() here!
        System.out.println("Do you Wanna Init The Driver (Y/N): ");
        char val = sc.next().charAt(0);
        if (val == 'Y' || val == 'y') {
            call.Reg_Drivermysql();
        } else if (val == 'N'|| val == 'n') {
            System.out.println("Thanks for the Query");
        }
        else { 
        	System.out.println("WRONG!!!");   
        	System.exit(0);
        }
        
        // Calling the Database Registration!
        System.out.println("Kindly enter the Url + Username and password for the database : ");
        String url = sc.next();
        String user = sc.next();
        String password = sc.next();
        call.dtb_reg(url, user, password);

        while (i != 0) {
            System.out.println("Hello User, Welcome to the Database Con Center. What would you like to do with the database?");
            System.out.println("1. View All Databases ");
            System.out.println("2. Add Database");
            System.out.println("3. Delete Database");
            System.out.println("4. Add Table");
            System.out.println("4. Delete Table");
            System.out.println("5. Make Changes to the Table");
            System.out.println("0. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                	call.viewDatabases();
                	System.out.println("Do you wanna use a database y>n : ");
                    int f = sc.nextInt();
                    if(f==1) {
                    	System.out.println("What is gonna be the database name? : ");
                    	String databasename = sc.next();
                    call.con(databasename);
                    System.out.println("The database you are currently in is : " + databasename);
                   } 
                    break;
                case 2:
                	System.out.println("What Do you want the database name to be : ");
            		@SuppressWarnings("unused")
            		String datbase = sc.next();
                    call.createDatabase(datbase);
                    break;
                case 3:
                    // Delete Table logic here
                	System.out.println("Which Database do you want delete: ");
            		@SuppressWarnings("unused")
            		String datbase1 = sc.next();
                    call.deleteDatabase(datbase1);
                	break;
                case 4:
                    System.out.println("Whats the tablename gonna be : ");
                    String tbname = sc.next();
                    call.Addtable(tbname);
                    
                    break;
                case 5:           	
                
                case 0:
                    System.out.println("Exiting Database Con Center. Goodbye!");
                    i = 0; // This will exit the while loop
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
