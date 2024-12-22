package view;

import model.Model;
import model.Toyota;
import service.ToyotaService;
import service.ToyotaServiceImpl;

import java.util.Scanner;

public class ToyotaView {
    private final ToyotaService toyotaService;

    public ToyotaView() {
        this.toyotaService = new ToyotaServiceImpl();
    }

    public void getAllToyota() {
        System.out.println("===== List Toyota ======");
        for (Toyota toyota : toyotaService.getAll()) {
            toyota.showInfo();
            System.out.println("------------------");
        }
        System.out.println("===== End List Toyota ======");
    }

    public void insertToyota() {
        System.out.println("===== Insert Toyota ======");
        Scanner scanner = new Scanner(System.in);
        toyotaService.insert(inputCar(scanner,0));
//        System.out.println("Toyota inserted successfully!");
    }

//    public void updateToyota() {
//        System.out.println("===== Update Toyota ======");
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the ID of the Toyota to update: ");
//        int id = scanner.nextInt();
//        Toyota existingToyota = toyotaService.getAllById(id);
//
//        if (existingToyota == null) {
//            System.out.println("Toyota with ID " + id + " not found!");
//            return;
//        }
//
//        System.out.print("Enter new Name (current: " + existingToyota.getName() + "): ");
//        scanner.nextLine(); // Clear the newline
//        String name = scanner.nextLine();
//        System.out.print("Enter new Year (current: " + existingToyota.getYear() + "): ");
//        String year = scanner.nextLine();
//        System.out.print("Enter new Model (current: " + existingToyota.getModel() + "): ");
//        String model = scanner.nextLine();
//        System.out.print("Enter new Color (current: " + existingToyota.getColor() + "): ");
//        String color = scanner.nextLine();
//
//        existingToyota.setName(name);
//        existingToyota.setYear(year);
//        existingToyota.setModel(model);
//        existingToyota.setColor(color);
//
//        toyotaService.update(existingToyota);
//        System.out.println("Toyota updated successfully!");
//    }
public void updateToyota() {
    System.out.println("===== Update Toyota ======");
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the ID of the Toyota to update (or 0 to cancel): ");
    int id = scanner.nextInt();
    if (id == 0) {
        System.out.println("Update canceled.");
        return;
    }

    Toyota existingToyota = toyotaService.getAllById(id);

    if (existingToyota == null) {
        System.out.println("Toyota with ID " + id + " not found!");
        return;
    }

    scanner.nextLine(); // Clear the newline after nextInt

    System.out.print("Enter new Name (current: " + existingToyota.getName() + ", or 0 to cancel): ");
    String name = scanner.nextLine();
    if (name.equals("0")) {
        System.out.println("Update canceled.");
        return;
    }

    System.out.print("Enter new Year (current: " + existingToyota.getYear() + ", or 0 to cancel): ");
    String year = scanner.nextLine();
    if (year.equals("0")) {
        System.out.println("Update canceled.");
        return;
    }

    System.out.print("Enter new Model (current: " + existingToyota.getModel() + ", or 0 to cancel): ");
    String model = scanner.nextLine();
    if (model.equals("0")) {
        System.out.println("Update canceled.");
        return;
    }

    System.out.print("Enter new Color (current: " + existingToyota.getColor() + ", or 0 to cancel): ");
    String color = scanner.nextLine();
    if (color.equals("0")) {
        System.out.println("Update canceled.");
        return;
    }

    // Update the Toyota object
    existingToyota.setName(name);
    existingToyota.setYear(year);
//    existingToyota.setModel(model);
    existingToyota.setColor(color);

    // Save the updated Toyota
    toyotaService.update(existingToyota);
    System.out.println("Toyota updated successfully!");
}

    public void deleteToyota() {
        System.out.println("===== Delete Toyota ======");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the Toyota to delete: ");
        int id = scanner.nextInt();

        Toyota toyota = toyotaService.getById(id);
        if (toyota == null) {
            System.out.println("Toyota with ID " + id + " not found!");
            return;
        }

        toyotaService.delete(id);
        System.out.println("Toyota with ID " + id + " deleted successfully!");
    }

    public void getByIdToyota() {
//        System.out.println("===== Get Toyota By ID ======");
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the ID of the Toyota: ");
//        int id = scanner.nextInt();
//
//        Toyota toyota = toyotaService.getAllById(id);
//        if (toyota == null) {
//            System.out.println("Toyota with ID " + id + " not found!");
//        } else {
//            System.out.println("Toyota Details:");
//            toyota.showInfo();
//        }
    }

    public void updateCar(Scanner scanner) {
        System.out.println("===== Update Car ======");
        System.out.print("Please Enter Car ID: ");
        int id = scanner.nextInt();
        var car = toyotaService.getById(id);
        if (car.getId() != 0) {
            showCar(car);
            car = inputCar(scanner,car.getId());
            toyotaService.update(car);
        }else{
            System.out.println("Car with ID " + id + " not found!");
        }
    }

    public Toyota inputCar(Scanner scanner, int id) {
        Model model = selectModel(scanner);
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Year: ");
        String year = scanner.next();
//        System.out.print("Enter Model: ");
//        String model = scanner.next();
        System.out.print("Enter Color: ");
        String color = scanner.next();

        Toyota toyota = new Toyota();
        toyota.setId(id); // Assuming ID is auto-generated
        toyota.setName(name);
        toyota.setYear(year);
        toyota.setColor(color);
        toyota.setModel(model);
        return toyota;

    }

    private Model selectModel(Scanner scanner) {
        System.out.println("===== Select Model ======");
        for (Model model : toyotaService.getAllModels()) {
            model.showSelectOption();
        }

//        Model model = new Model();
        System.out.print("Select model: ");
        int modelId = scanner.nextInt();
        Model model = toyotaService.getModelById(modelId);
        return model;
    }

    public void showCar(Toyota car){
        System.out.println("=========================");
        car.showInfo();
        System.out.println("=========================");
    }

    public void getCarDetail(Scanner scanner){
        System.out.println("Enter car id : ");
        var id = scanner.nextInt();
        var car = toyotaService.getById(id);
        if(car.getId() == 0){
            System.out.println("Car with ID " + id + " not found!");
        }else{
            showCar(car);
        }
    }

    public void deleteCar(Scanner scanner){
        System.out.println("Enter car id : ");
        var id = scanner.nextInt();
        var car = toyotaService.getById(id);
        if(car.getId() == 0){
            System.out.println("Car with ID " + id + " not found!");
        }else{
            toyotaService.delete(car.getId());
            showCar(car);
        }
    }
//    public void deleteCar(Scanner scanner){
//        System.out.println("Enter car id : ");
//        var id = scanner.nextInt();
//        var car = toyotaService.getById(id);
//        if(car.getId() == 0){
//        }
//            System.out.println("Car with ID " + id + " not found!");
//        }else{
//            toyotaService.delete(car.getId());
//            showCar(car);
//        }

}
