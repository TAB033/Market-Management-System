package mart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class productID{

    String s;

    public String createProductId()
    { 
        String idp;
        Outer:
            while(true)
            {
                idp = null;
                System.out.println(" ");
                System.out.println("Select category of new product.");
                System.out.println("```````````````````````````````");
                System.out.println("1. Food Product");
                System.out.println("2. Health Product");
                System.out.println("3. Every Day Essentials");
                System.out.println("4. Home & Kitchen Supplies");
                System.out.println(" ");
                System.out.print("Enter your choice: ");

                Scanner sca = new Scanner(System.in);
                int choice = sca.nextInt();
                System.out.print("\033[H\033[2J");

                switch(choice){
                    case 1:
                        idp = "FUD";
                        Inner:
                            while(true)
                            {
                                System.out.println(" ");
                                System.out.println("Select sub-category in Food category.");
                                System.out.println("`````````````````````````````````````");
                                System.out.println("1. Biskits");
                                System.out.println("2. Snacks");
                                System.out.println("3. Ice-cream");
                                System.out.println(" ");
                                System.out.print("Enter your choice: ");
                                int c = sca.nextInt();
                                System.out.print("\033[H\033[2J");

                                switch(c)
                                {
                                    case 1:
                                        idp = idp + "BIS";
                                        break;
                                    case 2:
                                        idp = idp + "SNK";
                                        break;
                                    case 3:
                                        idp = idp + "ICE";
                                        break;
                                    default:
                                        System.out.println(" ");
                                        System.out.print("\033[H\033[2J");
                                        System.out.println("Invalid Choice.");
                                        continue Inner;
                                }
                                break;
                            }
                        break;
                        
                    case 2:
                        idp = "HLT";
                        Inner:
                            while(true)
                            {
                                System.out.println(" ");
                                System.out.println("Select sub-category in Health category.");
                                System.out.println("```````````````````````````````````````");
                                System.out.println("1. Firstaid");
                                System.out.println("2. Liquid Medicine");
                                System.out.println("3. Medicine");
                                System.out.println(" ");
                                System.out.print("Enter your choice: ");
                                int c = sca.nextInt();
                                System.out.print("\033[H\033[2J");

                                switch(c)
                                {
                                    case 1:
                                        idp = idp + "FAD";
                                        break;
                                    case 2:
                                        idp = idp + "LQM";
                                        break;
                                    case 3:
                                        idp = idp + "MED";
                                        break;
                                    default:
                                        System.out.println(" ");
                                        System.out.print("\033[H\033[2J");
                                        System.out.println("Invalid Choice.");
                                        continue Inner;
                                }
                                break;
                            }
                        break;

                    case 3:
                        idp = "EDE";
                        Inner:
                            while(true)
                            {
                                System.out.println(" ");
                                System.out.println("Select sub-category in Every Day category.");
                                System.out.println("``````````````````````````````````````````");
                                System.out.println("1. Bathing or Washing");
                                System.out.println("2. Perfume");
                                System.out.println("3. Beauty and Styling");
                                System.out.println(" ");
                                System.out.print("Enter your choice: ");
                                int c = sca.nextInt();
                                System.out.print("\033[H\033[2J");

                                switch(c)
                                {
                                    case 1:
                                        idp = idp + "BTH";
                                        break;
                                    case 2:
                                        idp = idp + "PFM";
                                        break;
                                    case 3:
                                        idp = idp + "BTY";
                                        break;
                                    default:
                                        System.out.println(" ");
                                        System.out.print("\033[H\033[2J");
                                        System.out.println("Invalid Choice.");
                                        continue Inner;
                                }
                                break;
                            }
                        break;

                    case 4:
                        idp = "HOM";
                        Inner:
                            while(true)
                            {
                                System.out.println(" ");
                                System.out.println("Select sub-category in Home & Kitchen category.");
                                System.out.println("```````````````````````````````````````````````");
                                System.out.println("1. Cookware");
                                System.out.println("2. Decoration");
                                System.out.println(" ");
                                System.out.print("Enter your choice: ");
                                int c = sca.nextInt();
                                System.out.print("\033[H\033[2J");

                                switch(c)
                                {
                                    case 1:
                                        idp = idp + "COK";
                                        break;
                                    case 2:
                                        idp = idp + "DEC";
                                        break;
                                    default:
                                        System.out.println(" ");
                                        System.out.print("\033[H\033[2J");
                                        System.out.println("Invalid Choice.");
                                        continue Inner;
                                }
                                break;
                            }
                        break;

                    default:
                        System.out.println(" ");
                        System.out.print("\033[H\033[2J");
                        System.out.println("Invalid Choice.");
                        continue Outer;
                    }
                System.out.print("\033[H\033[2J");
                break;
            }

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
            System.err.println("An error occurred while reading data from the file: " + e.getMessage());
        }
        ind = 0;
        int i = 0;
        while(Arrr[ind] != null)
        {
            String[] save = Arrr[ind].split("~");
            String str = save[0].substring(0,6);
            if(str.equals(idp))
            {
                i++;
            }
            ind++;
        }
        String num;
        if(i == 0)
        {
            num = "001";
        }
        else
        {
            if(i < 9)
            {
                num = "00" + String.valueOf(i+1);  
            }
            else if(i < 99)
            {
                num = "0" + String.valueOf(i+1);
            }
            else
            {
                num = String.valueOf(i+1);
            }
        }

        s = idp + num;
        
        Scanner scann= new Scanner(System.in);
        System.out.print("Enter name of product: ");
        String nm = scann.nextLine();
        System.out.print("Enter price of product: ");
        double prc = scann.nextDouble();
        System.out.print("Enter quantity of product: ");
        int qu = scann.nextInt();
        
        try {
            // Use FileWriter with append mode (second parameter set to true)
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Create a BufferedWriter for efficient writing
            try (PrintWriter writer = new PrintWriter(fileWriter)) {
                // Write the data to the file
                writer.println(s + "~" + nm + "~" + prc + "~" + qu);
                System.out.print("\033[H\033[2J");
                System.out.println("Product added successfully.");
            }
        }catch (IOException e) {
                System.err.println("process failed.");
            }
        return s;
    }

}
