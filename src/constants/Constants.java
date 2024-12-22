package constants;

public interface Constants {
    String username = "postgres";
    String password = "1234";
//    String url="jdbc:postgresql://localhost:5477/car_db";
    String url="jdbc:postgresql://3.88.107.93:5477/car_db";
//    String sqlSelectAllCar = "select c.*, cm.name as model from car c left join car_model cm on cm.id=c.id";
//    String sqlSelectAllCar = "select * from car";
    String sqlSelectAllCar = "select c.*, cm.name as model from car c left join car_model cm on cm.id=c.model_id";
    String sqlSelectAllModels = "select * from car_model";
    String sqlInsertCar = "insert into car (name, color, years, model_id)\n" +
            "values(?,?,?,?)";
    String sqlSelectModelById = "select * from car_model where id=?";
    String id = "id";
    String name = "name";
    String color = "color";
    String years = "years";
    String model = "model";
    String modelId = "model_id";
}
