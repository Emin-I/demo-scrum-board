package com.example.restservice.mappers;

import com.example.restservice.dtos.Team;
import com.example.restservice.dtos.UserNoTeams;
import com.example.restservice.models.TeamModel;
import com.example.restservice.models.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-22T12:40:57+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public Team mapToDto(TeamModel teamModel) {
        if ( teamModel == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( teamModel.getId() );
        team.setName( teamModel.getName() );
        team.setCreatedDate( teamModel.getCreatedDate() );
        team.setUsers( userModelSetToUserNoTeamsHashSet( teamModel.getUsers() ) );

        return team;
    }

    @Override
    public List<Team> mapToDtos(List<TeamModel> teamModels) {
        if ( teamModels == null ) {
            return null;
        }

        List<Team> list = new ArrayList<Team>( teamModels.size() );
        for ( TeamModel teamModel : teamModels ) {
            list.add( mapToDto( teamModel ) );
        }

        return list;
    }

    @Override
    public TeamModel mapFromDto(Team teamDto) {
        if ( teamDto == null ) {
            return null;
        }

        TeamModel teamModel = new TeamModel();

        teamModel.setUsers( userNoTeamsHashSetToUserModelSet( teamDto.getUsers() ) );
        teamModel.setId( teamDto.getId() );
        teamModel.setName( teamDto.getName() );
        teamModel.setCreatedDate( teamDto.getCreatedDate() );

        return teamModel;
    }

    @Override
    public List<TeamModel> mapFromDtos(List<Team> teamDtos) {
        if ( teamDtos == null ) {
            return null;
        }

        List<TeamModel> list = new ArrayList<TeamModel>( teamDtos.size() );
        for ( Team team : teamDtos ) {
            list.add( mapFromDto( team ) );
        }

        return list;
    }

    protected Collection<Team> teamModelCollectionToTeamCollection(Collection<TeamModel> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<Team> collection1 = new ArrayList<Team>( collection.size() );
        for ( TeamModel teamModel : collection ) {
            collection1.add( mapToDto( teamModel ) );
        }

        return collection1;
    }

    protected UserNoTeams userModelToUserNoTeams(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserNoTeams userNoTeams = new UserNoTeams();

        userNoTeams.setId( userModel.getId() );
        userNoTeams.setFirstName( userModel.getFirstName() );
        userNoTeams.setUsername( userModel.getUsername() );
        userNoTeams.setLastName( userModel.getLastName() );
        userNoTeams.setMail( userModel.getMail() );
        userNoTeams.setAge( userModel.getAge() );
        userNoTeams.setPassword( userModel.getPassword() );
        userNoTeams.setTeams( teamModelCollectionToTeamCollection( userModel.getTeams() ) );

        return userNoTeams;
    }

    protected HashSet<UserNoTeams> userModelSetToUserNoTeamsHashSet(Set<UserModel> set) {
        if ( set == null ) {
            return null;
        }

        HashSet<UserNoTeams> hashSet = new HashSet<UserNoTeams>();
        for ( UserModel userModel : set ) {
            hashSet.add( userModelToUserNoTeams( userModel ) );
        }

        return hashSet;
    }

    protected Collection<TeamModel> teamCollectionToTeamModelCollection(Collection<Team> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<TeamModel> collection1 = new ArrayList<TeamModel>( collection.size() );
        for ( Team team : collection ) {
            collection1.add( mapFromDto( team ) );
        }

        return collection1;
    }

    protected UserModel userNoTeamsToUserModel(UserNoTeams userNoTeams) {
        if ( userNoTeams == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setTeams( teamCollectionToTeamModelCollection( userNoTeams.getTeams() ) );
        userModel.setId( userNoTeams.getId() );
        userModel.setFirstName( userNoTeams.getFirstName() );
        userModel.setLastName( userNoTeams.getLastName() );
        userModel.setMail( userNoTeams.getMail() );
        userModel.setAge( userNoTeams.getAge() );
        userModel.setUsername( userNoTeams.getUsername() );
        userModel.setPassword( userNoTeams.getPassword() );

        return userModel;
    }

    protected Set<UserModel> userNoTeamsHashSetToUserModelSet(HashSet<UserNoTeams> hashSet) {
        if ( hashSet == null ) {
            return null;
        }

        Set<UserModel> set = new LinkedHashSet<UserModel>( Math.max( (int) ( hashSet.size() / .75f ) + 1, 16 ) );
        for ( UserNoTeams userNoTeams : hashSet ) {
            set.add( userNoTeamsToUserModel( userNoTeams ) );
        }

        return set;
    }
}
