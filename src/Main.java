import view.ToyotaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyotaView toyotaView = new ToyotaView();
        Scanner scanner = new Scanner(System.in);
        int option;
        do{
            System.out.println("1. Add Toyota | 2. List Toyota | 3. Update Toyota | 4. Delete Toyota | 5. Get Toyota By ID | 6. Exit Application");
            System.out.println("Select Option: ");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    toyotaView.insertToyota();
                    break;
                case 2:
                    toyotaView.getAllToyota();
                    break;
                case 3:
                    toyotaView.updateToyota();
                    break;
                case 4:
                    toyotaView.deleteToyota();
                    break;
                case 5:
                    toyotaView.getByIdToyota();
                    break;
                case 6:
                    // Exit Application
                    System.out.println("Exiting the System...3 2 1");
                    break;
                default:
                    System.out.println("Error, Please re-select again!");
            }
        }while (option !=6);
        scanner.close();
    }
}