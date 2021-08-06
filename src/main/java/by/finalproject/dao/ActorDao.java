package by.finalproject.dao;

import by.finalproject.entity.Actor;
import by.finalproject.services.ConnectionManager;

import java.sql.*;

public class ActorDao {

    private static ActorDao INSTANCE;

    private ActorDao() {

    }

    public boolean saveActor(Actor actor){
        try (Connection connection = ConnectionManager.newConnection()) {
            String sql = "INSERT INTO actor (id,name,film,age) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            Long id=0L;
            if (generatedKeys.next()){
               id=generatedKeys.getLong(1);
            }
            statement.setLong(1,id);
            statement.setString(2,actor.getName());
            statement.setString(3,actor.getFilm());
            statement.setInt(4,actor.getAge());
            statement.executeUpdate();

            generatedKeys.close();
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

        private Actor actor;

    public Actor findById(Long id){

        try (Connection connection = ConnectionManager.newConnection()) {
            String sql = "SELECT * FROM actor WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
               actor = new Actor(id,resultSet.getString("name"),resultSet.getString("film"),resultSet.getInt("age"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return actor;
    }


    public static ActorDao newInstance(){
        if (INSTANCE==null){
            synchronized (ActorDao.class){
                if (INSTANCE==null){
                    INSTANCE=new ActorDao();
                }
            }
        }
        return INSTANCE;
    }
}
