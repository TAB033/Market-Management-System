package mart;

import java.io.*;
import java.util.*;

public class bill {
    
    public void makebill() throws IOException
    {
        while(true){
            int i = 0;
            String[] name = new String[100];
            int[] qu = new int[100];
            double[] price = new double[100];

            System.out.print("\033c");
            System.out.println("Note:: enter -1 in ProductID when no more products are left for billing.");
            System.out.println("````````````````````````````````````````````````````````````````````````");
            while(true)
            {
                System.out.println(" ");
                Scanner sce = new Scanner(System.in);
                System.out.println("Enter ProductID: ");
                String id = sce.nextLine();
                if(id.equals("-1"))
                {
                    System.out.print("\033c");
                    break;
                }
                System.out.println("Enter Quantity: ");
                int qun = sce.nextInt();

                File inputFile = new File("product.txt");
                File tempFile = new File("myTempFile.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

                String line;

                while((line = reader.readLine()) != null) {
                    String[] curr = line.split("~");
                    if(curr[0].equals(id))
                    {
                        if(Integer.valueOf(curr[3]) < qun){
                            System.out.println("This much quantity not available.");
                            writer.println(curr[0] + "~" + curr[1] + "~" + curr[2] + "~" + curr[3]);
                            i--;
                            qun = 0;
                            continue;
                        } 
                        name[i] = curr[1];
                        price[i] = Double.valueOf(curr[2]);
                        qu[i] = qun;
                        writer.println(curr[0] + "~" + curr[1] + "~" + curr[2] + "~" + String.valueOf(Integer.valueOf(curr[3]) - qun));
                        continue;
                    }
                    writer.println(line);
                }
                reader.close();
                writer.close();
                inputFile.delete();
                boolean successful = tempFile.renameTo(inputFile);
                i++;
            }


            String nm = null, number;
            if(name.length == 0) continue;

            Outer:
            while(true)
            {
                Scanner scn = new Scanner(System.in);
                System.out.print("\033c");
                System.out.println("Enter Customer's Mobile Number: ");
                number = scn.nextLine();
                if(number.length() != 10)
                {
                    System.out.println("Mobile Number must be of 10 digits.");
                    continue Outer;
                }

                String filePath = "customer.txt";
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath)) ) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] save = line.split("~");
                        if(save[0].equals(number))
                        {
                            nm = save[1];
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("File not found.");
                }

                if(nm == null)
                {
                    System.out.println("Enter Customer's Name: ");
                    nm = scn.nextLine();

                    String file = "customer.txt";
                    try {
                        // Use FileWriter with append mode (second parameter set to true)
                        FileWriter fileWriter = new FileWriter(file, true);

                        // Create a BufferedWriter for efficient writing
                        try (PrintWriter writer = new PrintWriter(fileWriter)) {
                            // Write the data to the file
                            writer.println(number + "~" + nm);
                        }
                    }catch (IOException e) {
                            System.err.println("Process failed.");
                        }

                } 
                break;
            }

            double total = 0;
            System.out.print("\033c");
            System.out.println(" ");
            System.out.println("###############################################################################");
            nm = String.format("%-68s", nm);
            System.out.println("# Name: " + nm + "  #");
            System.out.println("#`````````````````````````````````````````````````````````````````````````````#");
            System.out.println("#                Products                  Quantity      Price      Amount    #");
            System.out.println("#:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::#");
            for(int in=0; in<i; in++)
            {
                total += price[in] * qu[in];
                String s1 = String.format("%-40s", name[in]);
                String s2 = String.format("%5d",qu[in]);
                String s3 = String.format("%6.2f", price[in]);
                String s4 = String.format("%8.2f", price[in] * qu[in]);
                System.out.println("# " + s1 + s2 + "         " + s3 + "    " + s4 + "    #");
            }
            String s = String.format("%10s", total);
            System.out.println("#:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::#");
            System.out.println("#                                                         Total:"+s+"    #");
            System.out.println("###############################################################################");

            System.out.println(" ");
            System.out.println("Note:: type logout for logout // terminate for terminate the programe.");
            System.out.println("``````````````````````````````````````````````````````````````````````");
            Scanner sce = new Scanner(System.in);
            String c = sce.nextLine();
            if(c.equals("logout")) break; 
            else if(c.equals("terminate")) System.exit(0);
        }
    }
}
