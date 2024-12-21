package repository;

import constants.Constants;
import db.DbConnection;
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
                //String model = resultSet.getString(Constants.model);
                //int price = resultSet.getInt("price");
                Toyota toyota = new Toyota();
                toyota.setId(id);
                toyota.setName(name);
                toyota.setColor(color);
                toyota.setYear(year);
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
        if(toyota.getId()==0){
            toyota.setId(toyotaList.size()+1);
            toyotaList.add(toyota);
        }else{

        }
    }

    @Override
    public void delete(Toyota toyota) {
        toyotaList.remove(findById(toyota.getId()));
    }
}
