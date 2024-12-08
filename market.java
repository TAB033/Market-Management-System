
import java.io.*;
import java.util.*;
import java.util.Scanner;
import mart.*;

public class market{
    
    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        NEW_LOGIN:
        while(true){
        System.out.print("\033c");
        System.out.println("   #####################");
        System.out.println("   ||>     Login     <||");
        System.out.println("   #####################");
        System.out.println(" ");
        login l = new login(null, null);
        if(l.firstlogin())
        {
            Outer:
            while(true)
            {
                System.out.println(" ");
                System.out.println("1. Add Product");
                System.out.println("2. Add Mamber");
                System.out.println("3. Check Stock");
                System.out.println("4. Check staff's Details");
                System.out.println("5. Logout");
                System.out.println("6. Terminate");
                System.out.println("");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Select one from above: ");
                int choice = scanner.nextInt();
                System.out.print("\033c");

                switch (choice) 
                {
                    case 1:
                        System.out.println(" ");
                        System.out.println("Adding a Product,,");
                        System.out.println("``````````````````");
                        productID p = new productID();
                        System.out.println("Product Id: " + p.createProductId());
                        break;

                    case 2:
                        System.out.println(" ");
                        System.out.println("Adding a Member,,");
                        System.out.println("``````````````````");
                        member m = new member();
                        m.getinfo();
                        break;

                    case 3:
                        System.out.print("\033c");
                        System.out.println("Checking Stocks,,");
                        System.out.println("`````````````````");
                        System.out.println("1. View for all stock.");
                        System.out.println("2. Search by product-ID");
                        System.out.println("3. Exit");
                        System.out.println("");
                        System.out.print("Select one from above: ");
                        int c = scanner.nextInt();
                        System.out.print("\033c");

                        String filePath = "product.txt";
                        String Arrr[] = new String[1000];
                        int ind = 0;
                        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)) ) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                Arrr[ind] = line;
                                ind++;
                            }
                        } catch (IOException e) {
                            System.err.println("file not found");
                        }
                        ind = 0;
                        String save[] = new String[4];
                        if(c == 1)
                        {
                            System.out.print("\033c");
                            while(Arrr[ind] != null)
                            {
                                save = Arrr[ind].split("~");
                                System.out.println(save[3] + " units of " + save[1]);
                                ind++;
                            }
                        }
                        else if(c == 2)
                        {
                            System.out.println(" ");
                            System.out.print("Enter product-ID: ");
                            String s = scanner.next();
                            System.out.println();
                            while(Arrr[ind] != null)
                            {
                                save = Arrr[ind].split("~");
                                if(s.equals(save[0]))
                                {
                                    System.out.println(save[3] + " units of " + save[1]);
                                }
                                ind++;
                            }
                        }else if(c == 3){
                            break;
                        }else{
                            System.out.println("Invalid Choice.");
                        }
                        break;

                    case 4:
                        System.out.print("\033c");
                        System.out.println("Checking Details,,");
                        System.out.println("``````````````````");
                        String Path = "member.txt";
                        String Arr[] = new String[100];
                        int in = 0;
                        try (BufferedReader reader = new BufferedReader(new FileReader(Path)) ) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                Arr[in] = line;
                                in++;
                            }
                        } catch (IOException e) {
                            System.err.println("File not found.");
                        }
                        in = 0;
                        while(Arr[in] != null)
                        {
                            String[] sav = Arr[in].split("~");
                            System.out.println(" ");
                            System.out.println("Name: " + sav[3]);
                            System.out.println("Aadhar Number: " + sav[4]);
                            System.out.println("Mobile Number: " + sav[5]);
                            System.out.println("Qualification: " + sav[6]);
                            System.out.println("Email: " + sav[7]);
                            in++;
                        }
                        break;

                    case 5:
                        System.out.println(" ");
                        System.out.println("Successfully logout.");
                        System.out.println("````````````````````");
                        continue NEW_LOGIN;

                    case 6:
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice.");
                        continue Outer;
                }
            }
        }
        else
        {
            bill b = new bill();
            b.makebill();
        }
    }}
}
