package com.wecp.progressive.service.impl;

import java.util.*;

import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.wecp.progressive.entity.Team;
import com.wecp.progressive.service.TeamService;

//import antlr.collections.List;

public class TeamServiceImplArraylist implements TeamService {

    private static List<Team> teamList = new ArrayList<>();

    @Override
    public List<Team> getAllTeams() {
        // TODO Auto-generated method stub
        return teamList;
    }

    @Override
    public int addTeam(Team team) {
        // TODO Auto-generated method stub
        teamList.add(team);
        return teamList.size();
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        // TODO Auto-generated method stub
        List<Team> sortedTeam = teamList;
        sortedTeam.sort(Comparator.comparing(Team::getTeamName));
        return sortedTeam;
    }

    @Override
    public void emptyArrayList(){
        teamList = new ArrayList<>();
    }
    
}