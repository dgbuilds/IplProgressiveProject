package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Cricketer;
import com.wecp.progressive.entity.Match;

public class MatchDAOImpl implements MatchDAO{

    @Override
    public int addMatch(Match match) throws SQLException{
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement statement = null;
        int generatedID = -1;

        try{
            connection = DatabaseConnectionManager.getConnection();
            String sql = "INSERT INTO matches (firstTeamId , secondTeamId , matchDate , venue , result , status , winnerTeamId) VALUES (?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, match.getFirstTeamId());
            statement.setInt(2, match.getSecondTeamId());
            statement.setDate(3, match.getMatchDate());
            statement.setString(4, match.getVenue());
            statement.setString(5, match.getResult());
            statement.setString(6, match.getStatus());
            statement.setInt(7, match.getWinnerTeamId());
           
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next())
            {
                generatedID = rs.getInt(1); 
                match.setMatchId(generatedID);
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
    public Match getMatchById(int matchId) throws SQLException{
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM matches WHERE matchId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, matchId);

            ResultSet rs = statement.executeQuery();
            Match c = new Match();
            if(rs.next())
            {
                c.setMatchId(rs.getInt("matchId"));
                c.setFirstTeamId(rs.getInt("firstIeamId"));
                c.setSecondTeamId(rs.getInt("secondTeamId"));
                c.setMatchDate(rs.getDate("matchDate"));
                c.setVenue(rs.getString("venue"));
                c.setResult(rs.getString("result"));
                c.setStatus(rs.getString("status"));
                c.setWinnerTeamId(rs.getInt("winnerTeamId"));
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
    public void updateMatch(Match match) throws SQLException{
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE matches SET firstTeamId = ? , secondTeamId = ? , matchDate = ? , venue = ? , result = ? , status = ? , winnerTeamId = ? WHERE matchId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, match.getFirstTeamId());
            statement.setInt(2, match.getSecondTeamId());
            statement.setDate(3, match.getMatchDate());
            statement.setString(4, match.getVenue());
            statement.setString(5, match.getResult());
            statement.setString(6, match.getStatus());
            statement.setInt(7, match.getWinnerTeamId());
            statement.setInt(8, match.getMatchId());
        
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
    public void deleteMatch(int matchId) throws SQLException{
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DatabaseConnectionManager.getConnection();
            String sql = "DELETE FROM matches WHERE matchId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, matchId);
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
    public List<Match> getAllMatches() throws SQLException{
        // TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement statement = null;
        List<Match> list = new ArrayList<>();
        try{
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM matches";
            statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
                Match c = new Match();
            
                c.setMatchId(rs.getInt("matchId"));
                c.setFirstTeamId(rs.getInt("firstTeamId"));
                c.setSecondTeamId(rs.getInt("secondTeamId"));
                c.setMatchDate(rs.getDate("matchDate"));
                c.setVenue(rs.getString("venue"));
                c.setResult(rs.getString("result"));
                c.setStatus(rs.getString("status"));
                c.setWinnerTeamId(rs.getInt("winnerTeamId"));

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

    

