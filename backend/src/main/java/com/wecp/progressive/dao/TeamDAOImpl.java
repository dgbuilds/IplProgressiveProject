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

    @Override
    public int addTeam(Team team) {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public Team getTeamById(int teamId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateTeam(Team team) {
        // TODO Auto-generated method stub
       
    }

    @Override
    public void deleteTeam(int teamId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Team> getAllTeams() {
        // TODO Auto-generated method stub
        return List.of();
    }
    // private Connection connection;

    // public TeamDAOImpl()
    // {
    //     try{
    //         connection = DatabaseConnectionManager.getConnection();
    //     }
    //     catch(SQLException e){
    //         e.printStackTrace();
    //     }
    // }

    // public int addTeam(Team team)
    // {
    //     String sql = "INSERT INTO team (team_name , location , owner_name , establishment_year) VALUES (?,?,?,?)";
    //     try(PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS))
    //     {
    //         ps.setString(1, team.getTeam_name());
    //         ps.setString(2, team.getLocation());
    //         ps.setString(3,team.getOwner_name());
    //         ps.setInt(4, team.getEstablishment_year());
    //         ps.executeUpdate();

    //         ResultSet rs = ps.getGeneratedKeys();
    //         if(rs.next())
    //         {
    //             team.setTeam_id(rs.getInt(1));
    //             return team.getTeam_id();
    //         }
    //     }
    //     catch(SQLException e)
    //     {
    //         e.printStackTrace();
    //     }
    //     return -1;
    // }


    // public Team getTeamById(int teamId)
    // {
    //     String sql = "SELECT * FROM team WHERE team_id = ?";
    //     try(PreparedStatement ps = connection.prepareStatement(sql))
    //     {
    //         ps.setInt(1, teamId);
    //         ResultSet rs = ps.executeQuery();
    //         if(rs.next())
    //         {
    //             Team team = new Team();
    //             team.setTeam_id(rs.getInt("team_id"));
    //             team.setTeam_name(rs.getString("team_name"));
    //             team.setOwner_name(rs.getString("owner_name"));
    //             team.setLocation(rs.getString("location"));
    //             team.setEstablishment_year(rs.getInt("establishment_year"));
    //             return team;
    //         }
    //     }
    //     catch(SQLException e)
    //     {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }


    // public void updateTeam(Team team)
    // {
    //     String sql = "UPDATE team SET (team_name = ? , location = ? , owner_name = ? , establishment_year = ?) WHERE team_id = ?";
    //     try(PreparedStatement ps = connection.prepareStatement(sql))
    //     {
    //         ps.setString(1, team.getTeam_name());
    //         ps.setString(2, team.getLocation());
    //         ps.setString(3, team.getOwner_name());
    //         ps.setInt(4, team.getEstablishment_year());
    //         ps.executeUpdate();

    //     }
    //     catch(SQLException e)
    //     {
    //         e.printStackTrace();
    //     }
    // }


    // public void deleteTeam(int teamId)
    // {
    //     String sql = "DELETE FROM team WHERE team_id = ?";
    //     try(PreparedStatement ps = connection.prepareStatement(sql))
    //     {
    //         ps.setInt(1, teamId);
    //         ps.executeUpdate();
    //     }
    //     catch(SQLException e)
    //     {
    //         e.printStackTrace();
    //     }
    // }


    // public List<Team> getAllTeams()
    // {
    //     String sql = "SELECT * FROM team";
    //     List<Team> list = new ArrayList<>();
    //     try(PreparedStatement ps = connection.prepareStatement(sql))
    //     {
    //         ResultSet rs = ps.executeQuery();
    //         while(rs.next())
    //         {
    //             Team team = new Team();
    //             team.setTeam_id(rs.getInt("team_id"));
    //             team.setTeam_name(rs.getString("team_name"));
    //             team.setOwner_name(rs.getString("owner_name"));
    //             team.setLocation(rs.getString("location"));
    //             team.setEstablishment_year(rs.getInt("establishment_year"));
    //             list.add(team);
    //         }
    //     }
    //     catch(SQLException e)
    //     {
    //         e.printStackTrace();
    //     }
    //     return list;
    // }

}
