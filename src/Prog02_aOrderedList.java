import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Prog02_aOrderedList {

    static File file1; //Used for size finding

    /**
     * Main Method
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public static void main(String[] args) throws FileNotFoundException {
        String UserPrompt = "Enter input filename: ";
        aOrderedList oList = new aOrderedList();

        Scanner scan = GetInputFile(UserPrompt);
        carCreator(scan, oList);

        PrintWriter writeOut = getOutputFile();

        writeOut.println("Number of cars:   " + oList.size());
        writeOut.println();

        for(int i = 0; i < oList.size(); i++){
            Car car = (Car)oList.get(i);
            int money = car.getPrice();
          NumberFormat formatter = NumberFormat.getCurrencyInstance();

            writeOut.printf("Make: %15s%n", car.getMake());
            writeOut.printf("Year: %15d%n", car.getYear());
            writeOut.printf("Price: %14s%n", formatter.format(money));
            writeOut.println();
        }
        writeOut.close();
    }
    /**
     * Input File Retrieval
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String fileLocation = "";
        boolean exit = false;
        String temp = fileLocation;

        while (!exit) {

            System.out.printf(UserPrompt);

            fileLocation = scan.next();

            File fileTemp = new File(fileLocation);

            if (fileTemp.isFile()) {
                temp = fileLocation;
                exit = true;
            } else {
                System.out.println("File specified <" + fileLocation + "> does not exist. Would you like to continue? <Y/N>  ");

                Scanner terminate = new Scanner(System.in);
                Boolean progExit = false;

                while (!progExit) {
                    terminate.hasNext();
                    String progTerminate = terminate.nextLine();

                    try {
                        if (progTerminate.equalsIgnoreCase("N")) {
                            throw new FileNotFoundException();
                        } else if (progTerminate.equalsIgnoreCase("Y")) {
                            exit = false;
                            progExit = true;
                        } else {
                            System.out.println("Please enter a valid operator:");
                            progExit = false;
                        }
                    }
                    catch (FileNotFoundException e){
                        System.out.println("Program has been terminated.");
                    }
                }

            }
        }

        File file = new File(temp);
        Scanner inputFile = new Scanner(file);
        file1 = file;


        return inputFile;
    }
    /**
     * Output File Retrieval
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public static PrintWriter getOutputFile() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String fileLocation = "";
        boolean exit = false;
        String temp = fileLocation;

        while (!exit) {

            System.out.println("Enter file output name:");

            fileLocation = scan.next();

            File fileTemp = new File(fileLocation);

            if (fileTemp.isFile()) {
                temp = fileLocation;
                exit = true;
            } else {
                System.out.println("File specified <" + fileLocation + "> does not exist. Would you like to continue? <Y/N>  ");

                Scanner terminate = new Scanner(System.in);
                Boolean progExit = false;

                while (!progExit) {
                    terminate.hasNext();
                    String progTerminate = terminate.nextLine();
                    if (progTerminate.equalsIgnoreCase("N")) {
                        throw new FileNotFoundException();
                    } else if (progTerminate.equalsIgnoreCase("Y")) {
                        exit = false;
                        progExit = true;
                    } else {
                        System.out.printf("Please enter a valid operator:");
                        progExit = false;
                    }
                }

            }
        }
        File file = new File(temp);
        PrintWriter fileOutput = new PrintWriter(file);
        return fileOutput;
    }
    /**
     * File reading and Processing
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    private static aOrderedList carCreator(Scanner scan, aOrderedList oList) throws NoSuchElementException, FileNotFoundException {

        int removalCounter = 0;
        int insertionCounter = 0;

        int counter = 0;
        int control = 0;

        Scanner scanSize = new Scanner(file1);

        while (scanSize.hasNextLine()) {
            scanSize.nextLine();
            counter++;
        }

        for (int i = 0; i < counter; i++) {
          String[] strs = scan.nextLine().trim().split(",");

            if (strs[0].equalsIgnoreCase("a")){
                String Make = strs[1];
                int Year = Integer.parseInt(strs[2]);
                int Price = Integer.parseInt(strs[3]);

                Car car1 = new Car(Make, Year, Price);

                oList.add(car1);

                insertionCounter++;
            }
            else if (strs[0].equalsIgnoreCase("d") && strs.length > 2){
                String Make1 = strs[1];
                int Year1 = Integer.parseInt(strs[2]);

                for(int j = 0; j < oList.size() - 1; j++){
                    oList.reset();
                    Car car = (Car)oList.next();
                    String Make2 = car.getMake();
                    int Year2 = car.getYear();

                    if(Make1.equalsIgnoreCase(Make2)){
                        if(Year1 == Year2){
                            oList.remove(j);

                            control++;
                            removalCounter++;
                        }
                    }
                }


                //compare all elements to find location on array and delete.
            }
            else if (strs[0].equalsIgnoreCase("d") && strs.length <= 2){
                int delete = Integer.parseInt(strs[1]);
                oList.remove(delete);
                control++;
                removalCounter++;
            }

            if (oList.size() == 0 && strs[0].equalsIgnoreCase("d")){
                i--;
            }
        }

        if(oList.size() != insertionCounter - removalCounter) {
            for (int j = insertionCounter + removalCounter; j > insertionCounter; j--){
                oList.remove(oList.size() - 1 );

            }

        }

        return oList;
    }
}