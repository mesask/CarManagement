import view.ToyotaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyotaView toyotaView = new ToyotaView();
        Scanner scanner = new Scanner(System.in);
        int option;
        do{
            System.out.println("1. Add Car by Model | 2. List All Car | 3. Update Car | 4. Detail of Car by ID | 5. Delete Car by ID | 6. Exit Application");
            System.out.print("Select Option: ");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    toyotaView.insertToyota();
                    break;
                case 2:
                    toyotaView.getAllToyota();
                    break;
                case 3:
                    toyotaView.updateCar(scanner);
//                    toyotaView.updateToyota();
                    break;
                case 4:
                    toyotaView.getCarDetail(scanner);
//                    toyotaView.deleteToyota();
                    break;
                case 5:
                    toyotaView.deleteCar(scanner);
//                    toyotaView.getByIdToyota();
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