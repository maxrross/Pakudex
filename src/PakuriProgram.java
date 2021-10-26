import java.util.Scanner;

public class PakuriProgram {

    public static void main(String[] args) {
        //welcome and declaring scanner
        Scanner scan = new Scanner(System.in);
        Pakudex paku = new Pakudex();
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");

        //initalizing variables for this while loop for capacity input
        int cap = 0;
        String capString;
        int n = 1;
        //getting capacity through while loop to account for incorrect inputs
        while (n == 1) {
            boolean a = true;
            while(a){
                System.out.print("Enter max capacity of the Pakudex: ");
                capString = scan.next();
                try {
                    cap = Integer.parseInt(capString);
                    if (cap>0){
                        a=false;
                    }
                    while (cap<=0){
                        System.out.println("Please enter a valid size.");
                        break;
                    }
                } catch (Exception e){
                    System.out.println("Please enter a valid size.");
                }
            }
            try {
                n = 2;
                paku = new Pakudex(cap);
                System.out.println("The Pakudex can hold " + cap + " species of Pakuri.");
            } catch (Exception e) {
                System.out.println("Please enter a valid size.");
            }
        }
        //initalizing variables for this while loop to take input
        boolean flag = true;
        String input;
        int choice;
        while (flag) {
            //printing menu and taking input
            System.out.print(
                    "\n" +
                            "Pakudex Main Menu \n" +
                            "----------------- \n" +
                            "1. List Pakuri \n" +
                            "2. Show Pakuri \n" +
                            "3. Add Pakuri \n" +
                            "4. Evolve Pakuri \n" +
                            "5. Sort Pakuri \n" +
                            "6. Exit \n\n" +
                            "What would you like to do? ");
            input = scan.next();
            try {
                choice = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Unrecognized menu selection!");
                choice = 0;
            }
            while (choice <= 0 || choice >6) {
                System.out.println("Unrecognized menu selection!");
                System.out.print(
                        "\n" +
                                "Pakudex Main Menu \n" +
                                "----------------- \n" +
                                "1. List Pakuri \n" +
                                "2. Show Pakuri \n" +
                                "3. Add Pakuri \n" +
                                "4. Evolve Pakuri \n" +
                                "5. Sort Pakuri \n" +
                                "6. Exit \n\n" +
                                "What would you like to do? ");
                input = scan.next();
                try {
                    choice = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("Unrecognized menu selection!");
                    choice = 0;
                }
                break;
            }
            //switch statement for main code
                switch (choice) {
                    case 1:
                        //lists the pakuri separated by number . name
                        if (paku.getSize() <= 0) {
                            System.out.println("No Pakuri in Pakudex yet!");
                        } else {
                            String[] array = paku.getSpeciesArray();
                            System.out.println("Pakuri In Pakudex:");
                            for (int i = 0; i < array.length; i++) {
                                if (array[i]==null){
                                    continue;
                                }
                                System.out.println(i + 1 + ". " + array[i]);
                            }
                        }
                        break;
                    case 2:
                        //shows each pakuris stats and if doesnt exist prints error
                        System.out.print("Enter the name of the species to display: ");
                        String name = scan.next();
                        if (paku.getStats(name) != null) {
                            int[] stats = paku.getStats(name);
                            System.out.println("\nSpecies: " + name + "\n" +
                                    "Attack: " + stats[0] + "\n" +
                                    "Defense: " + stats[1] + "\n" +
                                    "Speed: " + stats[2]);
                        } else {
                            System.out.println("Error: No such Pakuri!");
                        }
                        break;
                    case 3:
                        //adds species to pakudex and accounts for 2 errors, already contains and full
                        if (paku.getSize() < paku.getCapacity()) {
                            System.out.print("Enter the name of the species to add: ");
                            String species = scan.next();
                            if (paku.addPakuri(species) == true) {
                                System.out.println("Pakuri species " + species + " successfully added!");
                            } else {
                                System.out.println("Error: Pakudex already contains this species!");
                                break;
                            }
                        } else {
                            System.out.println("Error: Pakudex is full!");
                        }
                        break;
                    case 4:
                        //evolves species in pakudex
                        System.out.print("Enter the name of the species to evolve: ");
                        name = scan.next();
                        if (paku.evolveSpecies(name) == true) {
                            System.out.println(name + " has evolved!");
                        } else {
                            System.out.println("Error: No such Pakuri!");
                        }
                        break;
                    case 5:
                        //sorts pakuri in alphabetical order
                        paku.sortPakuri();
                        System.out.println("Pakuri have been sorted!");
                        break;
                    case 6:
                        //ends program
                        System.out.println("Thanks for using Pakudex! Bye!");
                        flag = false;
                        break;
            }
        }
    }
}