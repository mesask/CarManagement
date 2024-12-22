package model;

public class Car {
    private int id;
    private String name;
    private Model model;
    private String year;
    private String color;
    // Constructor
    public Car() {
    }

    public Car(String year, int id, String name, Model model, String color) {
        this.year = year;
        this.id = id;
        this.name = name;
        this.model = model;
        this.color = color;
    }
    // Method Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void showInfo(){
        System.out.println("ID : "+this.id);
        System.out.println("Name : "+this.name);
        System.out.println("Model : "+this.model.getName());
        System.out.println("Year : "+this.year);
        System.out.println("Color : "+this.color);
    }
}
