package com.wecp.progressive.dao;

import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Cricketer;

public class CricketerDAOImpl implements CricketerDAO{

    @Override
    public int addCricketer(Cricketer cricketer) throws SQLException {
        System.out.println("heolllloooo");
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement statement = null;
        int generatedID = -1;

        try{
            connection = DatabaseConnectionManager.getConnection();
            String sql = "INSERT INTO cricketer (teamId , cricketerName , age , nationality , experience , role , totalRuns , totalWickets) VALUES (?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, cricketer.getTeamId());
            statement.setString(2, cricketer.getCricketerName());
            statement.setInt(3, cricketer.getAge());
            statement.setString(4, cricketer.getNationality());
            statement.setInt(5, cricketer.getExperience());
            statement.setString(6, cricketer.getRole());
            statement.setInt(7, cricketer.getTotalRuns());
            statement.setInt(8, cricketer.getTotalWickets());

            System.out.println(statement.executeUpdate());

            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next())
            {
                generatedID = rs.getInt(1);
                cricketer.setCricketerId(generatedID);
            }
        } catch(SQLException e){
            e.printStackTrace();
            throw e;
        }finally {
            if(statement != null)
            {
                statement.close();
            }
        }
        return generatedID;
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException{
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM cricketer WHERE cricketerId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, cricketerId);

            ResultSet rs = statement.executeQuery();
            Cricketer c = new Cricketer();
            if(rs.next())
            {
                c.setCricketerId(rs.getInt("cricketerId"));
                c.setTeamId(rs.getInt("teamId"));
                c.setCricketerName(rs.getString("cricketerName"));
                c.setAge(rs.getInt("age"));
                c.setNationality(rs.getString("nationality"));
                c.setExperience(rs.getInt("experience"));
                c.setRole(rs.getString("role"));
                c.setTotalRuns(rs.getInt("totalRuns"));
                c.setTotalWickets(rs.getInt("totalWickets"));
                return c;
            }
        } catch(SQLException e){
            e.printStackTrace();
            throw e;
        }finally {
            if(statement != null)
            {
                statement.close();
            }
        }
        return null;
    }

    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException{
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE cricketer SET teamId = ? , cricketerName = ? , age = ? , nationality = ? , experience = ? , role = ? , totalRuns = ? , totalWickets = ? WHERE cricketerId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, cricketer.getTeamId());
            statement.setString(2, cricketer.getCricketerName());
            statement.setInt(3, cricketer.getAge());
            statement.setString(4, cricketer.getNationality());
            statement.setInt(5, cricketer.getExperience());
            statement.setString(6, cricketer.getRole());
            statement.setInt(7, cricketer.getTotalRuns());
            statement.setInt(8, cricketer.getTotalWickets());
            statement.setInt(9,cricketer.getCricketerId());
            statement.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
            throw e;
        }finally {
            if(statement != null)
            {
                statement.close();
            }
        }
    }

    @Override
    public void deleteCricketer(int cricketerId) throws SQLException{
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DatabaseConnectionManager.getConnection();
            String sql = "DELETE FROM cricketer WHERE cricketerId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, cricketerId);
            statement.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
            throw e;
        }finally {
            if(statement != null)
            {
                statement.close();
            }
        }
       }

    @Override
    public List<Cricketer> getAllCricketers() throws SQLException{
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement statement = null;
        List<Cricketer> list = new ArrayList<>();
        try{
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM cricketer";
            statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
                Cricketer c = new Cricketer();
                c.setCricketerId(rs.getInt("cricketer_id"));
                c.setTeamId(rs.getInt("team_id"));
                c.setCricketerName(rs.getString("cricketer_name"));
                c.setAge(rs.getInt("age"));
                c.setNationality(rs.getString("nationality"));
                c.setExperience(rs.getInt("experience"));
                c.setRole(rs.getString("role"));
                c.setTotalRuns(rs.getInt("total_runs"));
                c.setTotalWickets(rs.getInt("total_wickets"));
                list.add(c);
            }
        } catch(SQLException e){
            e.printStackTrace();
            throw e;
        }finally {
            if(statement != null)
            {
                statement.close();
            }
        }
        return list;
    }

}
