package repository;

import constants.Constants;
import db.DbConnection;
import model.Car;
import model.Model;
import model.Toyota;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToyotaRepositoryImpl implements ToyotaRepository {
    //private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    //private Statement statement;
    private ResultSet resultSet;

    //Data Local
    List<Toyota> toyotaList = new ArrayList<>();
    @Override
    public List<Toyota> findAll() {
        List<Toyota> list = new ArrayList<>();
        try {
            preparedStatement = DbConnection.getConnection().prepareStatement(Constants.sqlSelectAllCar);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                int id = resultSet.getInt(Constants.id);
//                String name = resultSet.getString(Constants.name);
//                String color = resultSet.getString(Constants.color);
//                String year = resultSet.getString(Constants.years);
//                int modelId = resultSet.getInt(Constants.modelId);
//                String modelName = resultSet.getString(Constants.model);
//                //int price = resultSet.getInt("price");
//                Toyota toyota = new Toyota();
//                toyota.setId(id);
//                toyota.setName(name);
//                toyota.setColor(color);
//                toyota.setYear(year);
//                Model model = new Model(modelId, modelName);
//                toyota.setModel(model);
                //toyota.setModel(model);
                list.add(convertData(resultSet));
            }
        } catch (SQLException e){
            System.out.println("Error Get all car "+e);
        }
        return list;
    }

    @Override
    public Toyota findById(int id) {
        var toyota = new Toyota();
        try{
            preparedStatement = DbConnection.getConnection().prepareStatement(Constants.sqlSelectCarById);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                toyota = convertData(resultSet);
            }
            return toyota;
        }catch (Throwable e){
            System.out.println("Error Get by id error !!!"+e);
        }
        return null;
//        for (Toyota toyota : toyotaList) {
//            if (toyota.getId()==id) {
//
//                return toyota;
//            }
//        }
//        return null;
    }

    @Override
    public void save(Toyota toyota) {
        try{
//                preparedStatement.setString(1, toyota.getName());
//                preparedStatement.setString(2, toyota.getColor());
//                preparedStatement.setString(3, toyota.getYear());
//                preparedStatement.setInt(4, toyota.getModel().getId());
            if(toyota.getId()==0){
                preparedStatement = DbConnection.getConnection().prepareStatement(Constants.sqlInsertCar);
                preparedStatement.setString(1, toyota.getName());
                preparedStatement.setString(2, toyota.getColor());
                preparedStatement.setString(3, toyota.getYear());
                preparedStatement.setInt(4, toyota.getModel().getId());
                int result = preparedStatement.executeUpdate();
                if(result>0) {
                    System.out.println("Insert Success, Car added successfully !!!");
                }else{
                    System.out.println("Failed to Insert Data, Car not added !!!");
                }
                }else{
                preparedStatement = DbConnection.getConnection().prepareStatement(Constants.sqlUpdateCar);
                preparedStatement.setString(1, toyota.getName());
                preparedStatement.setString(2, toyota.getColor());
                preparedStatement.setString(3, toyota.getYear());
                preparedStatement.setInt(4, toyota.getModel().getId());
                preparedStatement.setInt(5, toyota.getId());
                int result = preparedStatement.executeUpdate();
                if(result>0) {
                    System.out.println("Update Success, Car updated successfully !!!");
                }else{
                    System.out.println("Failed to Update Data, Car not Update !!!");
                }
            }

        }catch (Exception e){
            System.out.println("Error update car !!!"+e);
        }



    }
//        try {
//            if (toyota.getId() == 0) {
//                preparedStatement = DbConnection.getConnection().prepareStatement(Constants.sqlInsertCar);
//                preparedStatement.setString(1, toyota.getName());
//                preparedStatement.setString(2, toyota.getColor());
//                preparedStatement.setString(3, toyota.getYear());
//                preparedStatement.setInt(4, toyota.getModel().getId());
//                int result = preparedStatement.executeUpdate();
//                if (result > 0) {
//                    System.out.println("Insert car successfully");
//                } else {
//                    System.out.println("Insert car failed");
//                }
//            }
//        } catch (Throw e) {
//            System.out.println("Error Saving toyota" + e);
//        }
//    }
//    }
//        if(toyota.getId()==0) {
//            try {
//                preparedStatement =
////            toyota.setId(toyotaList.size()+1);
////            toyotaList.add(toyota);
//            }else{
//
//            }
//        }catch (Throwable e){
//            System.out.println("Error Saving toyota");
//        }


    @Override
    public void delete(Toyota toyota) {
        try{
            preparedStatement = DbConnection.getConnection().prepareStatement(Constants.sqlDeleteCar);
            preparedStatement.setInt(1, toyota.getId());
            int result = preparedStatement.executeUpdate();
            if(result>0) {
                System.out.println("Delete Success, Car deleted successfully !!!");
            }else{
                System.out.println("Delete Failed !!!");
            }
        }catch (Throwable e){
            System.out.println("Delete Car Error : "+e.getMessage());
        }
//        toyotaList.remove(findById(toyota.getId()));
    }

//    @Override
//    public Model findModelById(int id) {
//        return null;
//    }

    @Override
    public List<Model> findAllModels() {
        List<Model> list = new ArrayList<>();
        try{
            preparedStatement = DbConnection.getConnection().prepareStatement(Constants.sqlSelectAllModels);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Model model = new Model(
                        resultSet.getInt(Constants.id),
                        resultSet.getString(Constants.name)
                );
                list.add(model);
            }
        }catch(Exception e){
            System.out.println("Error Get all models of car "+e);
        }
        return list;


    }

//    @Override
//    public List<Model> findAllModels() {
//        List<Model> list = new ArrayList<>();
//        try {
//            preparedStatement = DbConnection.getConnection().prepareStatement(Constants.sqlSelectAllModels);
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                Model model = new Model(
//                        resultSet.getInt(Constants.id)
//                        resultSet.getString(Constants.name)
//                );
//            }
//        }
//    }

    @Override
    public Model findModelById(int id) {
        try{
            preparedStatement = DbConnection.getConnection().prepareStatement(Constants.sqlSelectModelById);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Model model = new Model(
                        resultSet.getInt(Constants.id),
                        resultSet.getString(Constants.name)
                );
                return model;
            }
        }catch (Exception e){
            System.out.println("Error, Model not found !!! "+e);

        }
        return null;

    }

    public Toyota convertData(ResultSet resultSet) throws SQLException {
            int id = resultSet.getInt(Constants.id);
            String name = resultSet.getString(Constants.name);
            String color = resultSet.getString(Constants.color);
            String year = resultSet.getString(Constants.years);
            int modelId = resultSet.getInt(Constants.modelId);
            String modelName = resultSet.getString(Constants.model);
            //int price = resultSet.getInt("price");
            Toyota toyota = new Toyota();
            toyota.setId(id);
            toyota.setName(name);
            toyota.setColor(color);
            toyota.setYear(year);
            Model model = new Model(modelId, modelName);
            toyota.setModel(model);
            return toyota;
    }
}
