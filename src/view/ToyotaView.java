package view;

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
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Year: ");
        String year = scanner.next();
        System.out.print("Enter Model: ");
        String model = scanner.next();
        System.out.print("Enter Color: ");
        String color = scanner.next();

        Toyota toyota = new Toyota();
        toyota.setId(0); // Assuming ID is auto-generated
        toyota.setName(name);
        toyota.setYear(year);
        toyota.setModel(model);
        toyota.setColor(color);
        toyotaService.insert(toyota);
        System.out.println("Toyota inserted successfully!");
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
    existingToyota.setModel(model);
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

        Toyota toyota = toyotaService.getAllById(id);
        if (toyota == null) {
            System.out.println("Toyota with ID " + id + " not found!");
            return;
        }

        toyotaService.delete(id);
        System.out.println("Toyota with ID " + id + " deleted successfully!");
    }

    public void getByIdToyota() {
        System.out.println("===== Get Toyota By ID ======");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the Toyota: ");
        int id = scanner.nextInt();

        Toyota toyota = toyotaService.getAllById(id);
        if (toyota == null) {
            System.out.println("Toyota with ID " + id + " not found!");
        } else {
            System.out.println("Toyota Details:");
            toyota.showInfo();
        }
    }
}
