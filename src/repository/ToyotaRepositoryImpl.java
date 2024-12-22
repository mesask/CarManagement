package repository;

import constants.Constants;
import db.DbConnection;
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
                //toyota.setModel(model);
                list.add(toyota);
            }
        } catch (SQLException e){
            System.out.println("Error Get all car "+e);
        }

        return list;
    }

    @Override
    public Toyota findById(int id) {
        for (Toyota toyota : toyotaList) {
            if (toyota.getId()==id) {

                return toyota;
            }
        }
        return null;
    }

    @Override
    public void save(Toyota toyota) {
        try{
            if(toyota.getId()==0){
                preparedStatement = DbConnection.getConnection().prepareStatement(Constants.sqlInsertCar);
                preparedStatement.setString(1, toyota.getName());
                preparedStatement.setString(2, toyota.getColor());
                preparedStatement.setString(3, toyota.getYear());
                preparedStatement.setInt(4, toyota.getModel().getId());
                int result = preparedStatement.executeUpdate();
                if(result>0) {
                    System.out.println("Car added successfully !!!");
                }else{
                    System.out.println("Failed, Car not added !!!");
                }
                }else{
            }

        }catch (Exception e){
            System.out.println("Error Saving toyota"+e);
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
        toyotaList.remove(findById(toyota.getId()));
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
}
