package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Team;

public class TeamDAOImpl implements TeamDAO{

    // @Override
    // public int addTeam(Team team) {
    //     // TODO Auto-generated method stub
    //     return -1;
    // }

    // @Override
    // public Team getTeamById(int teamId) {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @Override
    // public void updateTeam(Team team) {
    //     // TODO Auto-generated method stub
       
    // }

    // @Override
    // public void deleteTeam(int teamId) {
    //     // TODO Auto-generated method stub
        
    // }

    // @Override
    // public List<Team> getAllTeams() {
    //     // TODO Auto-generated method stub
    //     return List.of();
    // }
    private Connection connection;

    public TeamDAOImpl()
    {
        try{
            connection = DatabaseConnectionManager.getConnection();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int addTeam(Team team)
    {
        String sql = "INSERT INTO team (teamName , location , ownerName , establishmentYear) VALUES (?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS))
        {
            ps.setString(1, team.getTeamName());
            ps.setString(2, team.getLocation());
            ps.setString(3,team.getOwnerName());
            ps.setInt(4, team.getEstablishmentYear());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                team.setTeamId(rs.getInt(1));
                return team.getTeamId();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }


    public Team getTeamById(int teamId)
    {
        String sql = "SELECT * FROM team WHERE teamId = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1, teamId);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                Team team = new Team();
                team.setTeamId(rs.getInt("teamId"));
                team.setTeamName(rs.getString("teamName"));
                team.setOwnerName(rs.getString("ownerName"));
                team.setLocation(rs.getString("location"));
                team.setEstablishmentYear(rs.getInt("establishmentYear"));
                return team;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public void updateTeam(Team team)
    {
        String sql = "UPDATE team SET (teamName = ? , location = ? , ownerName = ? , establishmentYear = ?) WHERE teamId = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1, team.getTeamName());
            ps.setString(2, team.getLocation());
            ps.setString(3, team.getOwnerName());
            ps.setInt(4, team.getEstablishmentYear());
            ps.executeUpdate();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }


    public void deleteTeam(int teamId)
    {
        String sql = "DELETE FROM team WHERE teamId = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1, teamId);
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }


    public List<Team> getAllTeams()
    {
        String sql = "SELECT * FROM team";
        List<Team> list = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Team team = new Team();
                team.setTeamId(rs.getInt("teamId"));
                team.setTeamName(rs.getString("teamName"));
                team.setOwnerName(rs.getString("ownerName"));
                team.setLocation(rs.getString("location"));
                team.setEstablishmentYear(rs.getInt("establishmentYear"));
                list.add(team);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

}
