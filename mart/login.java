package mart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class login{
    private String username;
    private String password;
    public String st;

    public login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean firstlogin()
    {
        String inputUsername = " ", inputPassword = " ";
        login l1 = new login(inputUsername, inputPassword);
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        
        do{
            if(flag)
            {
                System.out.println(" ");
                System.out.print("\033c");
                System.out.println("Invelid username or password.");
            }
            System.out.print("Enter username: ");
            inputUsername = sc.nextLine();
            System.out.print("Enter password: ");
            inputPassword = sc.nextLine();
            flag = true;
            l1 = new login(inputUsername, inputPassword);
        }while(!l1.authenticate()[0]);

        setUsername(inputUsername);
        setPassword(inputPassword);
        System.out.println(" ");
        System.out.print("\033c");
        System.out.println("Successfully login.");
        System.out.println("Welcome " + l1.getUsername() + ",");
        return l1.authenticate()[1];
    }

    public boolean[] authenticate() {
        String filePath = "member.txt";
        String Arrr[] = new String[100];
        int ind = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)) ) {
            String line;
            while ((line = reader.readLine()) != null) {
                Arrr[ind] = line;
                ind++;
            }
        } catch (IOException e) {
            System.err.println("File not found.");
        }
        ind = 0;
        boolean[] bo = new boolean[2];
        while(Arrr[ind] != null)
        {
            String[] save = Arrr[ind].split("~");
            if(username.equals(save[1]) && password.equals(save[2]))
            {
                bo[0] = true;
                bo[1] = save[0].equals("manager");
                return bo;
            }
            ind++;
        }
        return bo;
    }

    public void setUsername(String name)
    {
        this.username = name;
    }

    public void setPassword(String pass)
    {
        this.password = pass;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

}
