package mart;

import java.io.*;
import java.util.*;


public class member{

    public boolean validate(String Username, String Password)
    {
        if(Username.length() > 15 || Username.length() < 6)
        {
            System.out.print("\033c");
            System.out.println("Username must be in range of 6 - 15 character.");
            return false;
        }
        for (char c : Username.toCharArray()) {
            if (Character.isWhitespace(c)) {
                System.out.print("\033c");
                System.out.println("whitespaces is not allowed in username.");
                return false;
            }
        }

        if(Password.length() > 20 || Password.length() < 8)
        {
            System.out.print("\033c");
            System.out.println("Password must be in range of 8 - 20 character.");
            return false;
        }
        for (char c : Password.toCharArray()) {
            if (Character.isWhitespace(c)) {
                System.out.print("\033c");
                System.out.println("whitespaces is not allowed in password.");
                return false;
            }
        }

        if(Username.equals(Password))
        {
            System.out.print("\033c");
            System.out.println("Username and password must be not same.");
            return false;
        }
        return true;
    }


    public void getinfo()
    {
        Scanner scan = new Scanner(System.in);
        String name, pass;
        do{
        System.out.println(" ");
        System.out.print("Create username: ");
        name = scan.nextLine();
        System.out.print("Create password: ");
        pass = scan.nextLine();
        }while(!validate(name, pass));

        System.out.println(" ");
        System.out.print("\033c");
        System.out.println("Enter all details:");
        Outer:
            while(true)
            {
                System.out.print("Enter post (manager / staff) : ");
                String po = scan.nextLine();
                if(!("manager".equals(po) || "staff".equals(po)))
                {
                    System.out.print("\033c");
                    System.out.println("Enter valid post");
                    continue Outer;
                }

                System.out.println(" ");
                System.out.print("Full name: ");
                String fname = scan.nextLine();

                System.out.println(" ");
                System.out.print("Aadharcard number: ");
                String aadhar = scan.nextLine();
                if(aadhar.length() != 12)
                {
                    System.out.print("\033c");
                    System.out.println("Aadhar number must be of 12 digits.");
                    continue Outer;
                }

                System.out.println(" ");
                System.out.print("Mobile number: ");
                String number = scan.nextLine();
                if(number.length() != 10)
                {
                    System.out.print("\033c");
                    System.out.println("Mobile number must be of 10 digit.");
                    continue Outer;
                }

                System.out.println(" ");
                System.out.print("Qualification: ");
                String q = scan.nextLine();

                System.out.println(" ");
                System.out.print("Email: ");
                String email = scan.nextLine();
                addMember(po, name, pass, fname, aadhar, number, q, email);
                break;
            }
    }

    public void addMember(String post, String membername, String memberpass, String fname, String aadhar, String mobile, String qoli, String email)
    {
        String filePath = "member.txt";
        try {
            // Use FileWriter with append mode (second parameter set to true)
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Create a BufferedWriter for efficient writing
            try (PrintWriter writer = new PrintWriter(fileWriter)) {
                // Write the data to the file
                writer.println(post + "~" + membername + "~" + memberpass + "~" + fname + "~" + aadhar + "~" + mobile + "~" + qoli + "~" + email);
                System.out.print("\033c");
                System.out.println("Member added successfully.");
            }
        }catch (IOException e) {
                System.err.println("Process failed.");
            }
    }
}
