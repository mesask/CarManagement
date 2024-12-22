package model;

public class Model {
    // Field
    private int id;
    private String name;
    // Constructor
    public Model() {
    }

    public Model(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

//    public static void main(String[] args) {
//        Model model = new Model();
//    }
    public void showSelectOption(){
        System.out.println(this.id + "-" + this.getName());
    }
}
