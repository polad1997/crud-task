/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modell.Developer;

/**
 *
 * @author hp
 */
public class DeveloperManager extends DatabaseConnector {

    public void addDeveloper(Developer developer) throws ClassNotFoundException, SQLException {
        connect();
        try {
            preparedStatement = connection.prepareStatement(Queries.INSERT);
            preparedStatement.setInt(1, developer.getDev_ID());
            preparedStatement.setString(2, developer.getName());
            preparedStatement.setString(3, developer.getSurname());
            preparedStatement.setString(4, developer.getEmail());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public void updateDeveloper(Developer developer) throws ClassNotFoundException, SQLException {
        connect();
        try {
            preparedStatement = connection.prepareStatement(Queries.UPDATE);
            preparedStatement.setString(1, developer.getName());
            preparedStatement.setString(2, developer.getSurname());
            preparedStatement.setString(3, developer.getEmail());
            preparedStatement.setInt(4, developer.getDev_ID());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception : " + e);
        } finally {
            disconnect();
        }
    }

    public void deleteDeveloper(Integer Dev_id) throws ClassNotFoundException, SQLException {
        connect();
        try {
            preparedStatement = connection.prepareStatement(Queries.DELETE);
            preparedStatement.setInt(1, Dev_id);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public List<Developer> getAllDevelopers() throws ClassNotFoundException, SQLException {
        connect();
        List<Developer> developers = new ArrayList<>();
        preparedStatement = connection.prepareStatement(Queries.SELECT);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Developer developer = new Developer();
            developer.setDev_ID(resultSet.getInt("Dev_ID"));
            developer.setName(resultSet.getString("Name"));
            developer.setSurname(resultSet.getString("Surname"));
            developer.setEmail(resultSet.getString("Email"));
            developers.add(developer);
        }
        disconnect();
        return developers;

    }

}
