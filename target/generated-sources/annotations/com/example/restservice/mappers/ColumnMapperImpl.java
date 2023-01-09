package com.example.restservice.mappers;

import com.example.restservice.dtos.Column;
import com.example.restservice.dtos.Team;
import com.example.restservice.dtos.UserNoTeams;
import com.example.restservice.models.ColumnModel;
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
    date = "2023-01-09T17:17:01+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class ColumnMapperImpl implements ColumnMapper {

    @Override
    public Column mapToDto(ColumnModel columnModel) {
        if ( columnModel == null ) {
            return null;
        }

        Column column = new Column();

        column.setId( columnModel.getId() );
        column.setName( columnModel.getName() );
        column.setColour( columnModel.getColour() );
        column.setSequence( columnModel.getSequence() );
        column.setTeam( teamModelToTeam( columnModel.getTeam() ) );

        return column;
    }

    @Override
    public List<Column> mapToDtos(List<ColumnModel> columnModels) {
        if ( columnModels == null ) {
            return null;
        }

        List<Column> list = new ArrayList<Column>( columnModels.size() );
        for ( ColumnModel columnModel : columnModels ) {
            list.add( mapToDto( columnModel ) );
        }

        return list;
    }

    @Override
    public ColumnModel mapFromDto(Column columnDto) {
        if ( columnDto == null ) {
            return null;
        }

        ColumnModel columnModel = new ColumnModel();

        columnModel.setTeam( teamToTeamModel( columnDto.getTeam() ) );
        columnModel.setId( columnDto.getId() );
        columnModel.setName( columnDto.getName() );
        columnModel.setColour( columnDto.getColour() );
        columnModel.setSequence( columnDto.getSequence() );

        return columnModel;
    }

    @Override
    public List<ColumnModel> mapFromDtos(List<Column> columnDtos) {
        if ( columnDtos == null ) {
            return null;
        }

        List<ColumnModel> list = new ArrayList<ColumnModel>( columnDtos.size() );
        for ( Column column : columnDtos ) {
            list.add( mapFromDto( column ) );
        }

        return list;
    }

    protected Collection<Team> teamModelCollectionToTeamCollection(Collection<TeamModel> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<Team> collection1 = new ArrayList<Team>( collection.size() );
        for ( TeamModel teamModel : collection ) {
            collection1.add( teamModelToTeam( teamModel ) );
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

    protected Team teamModelToTeam(TeamModel teamModel) {
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

    protected Collection<TeamModel> teamCollectionToTeamModelCollection(Collection<Team> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<TeamModel> collection1 = new ArrayList<TeamModel>( collection.size() );
        for ( Team team : collection ) {
            collection1.add( teamToTeamModel( team ) );
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

    protected TeamModel teamToTeamModel(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamModel teamModel = new TeamModel();

        teamModel.setUsers( userNoTeamsHashSetToUserModelSet( team.getUsers() ) );
        teamModel.setId( team.getId() );
        teamModel.setName( team.getName() );
        teamModel.setCreatedDate( team.getCreatedDate() );

        return teamModel;
    }
}
