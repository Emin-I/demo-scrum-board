package com.example.restservice.mappers;

import com.example.restservice.dtos.Team;
import com.example.restservice.dtos.TeamNoUsers;
import com.example.restservice.dtos.User;
import com.example.restservice.dtos.UserNoTeams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-09T17:17:00+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class UserDtoDtoMapperImpl implements UserDtoDtoMapper {

    @Override
    public UserNoTeams mapToNoTeams(User user) {
        if ( user == null ) {
            return null;
        }

        UserNoTeams userNoTeams = new UserNoTeams();

        userNoTeams.setId( user.getId() );
        userNoTeams.setFirstName( user.getFirstName() );
        userNoTeams.setUsername( user.getUsername() );
        userNoTeams.setLastName( user.getLastName() );
        userNoTeams.setMail( user.getMail() );
        userNoTeams.setAge( user.getAge() );
        userNoTeams.setPassword( user.getPassword() );
        userNoTeams.setTeams( teamNoUsersCollectionToTeamCollection( user.getTeams() ) );

        return userNoTeams;
    }

    @Override
    public User mapFromNoTeams(UserNoTeams userNoTeams) {
        if ( userNoTeams == null ) {
            return null;
        }

        User user = new User();

        user.setId( userNoTeams.getId() );
        user.setFirstName( userNoTeams.getFirstName() );
        user.setUsername( userNoTeams.getUsername() );
        user.setLastName( userNoTeams.getLastName() );
        user.setMail( userNoTeams.getMail() );
        user.setAge( userNoTeams.getAge() );
        user.setPassword( userNoTeams.getPassword() );
        user.setTeams( teamCollectionToTeamNoUsersCollection( userNoTeams.getTeams() ) );

        return user;
    }

    protected HashSet<UserNoTeams> userHashSetToUserNoTeamsHashSet(HashSet<User> hashSet) {
        if ( hashSet == null ) {
            return null;
        }

        HashSet<UserNoTeams> hashSet1 = new HashSet<UserNoTeams>();
        for ( User user : hashSet ) {
            hashSet1.add( mapToNoTeams( user ) );
        }

        return hashSet1;
    }

    protected Team teamNoUsersToTeam(TeamNoUsers teamNoUsers) {
        if ( teamNoUsers == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( teamNoUsers.getId() );
        team.setName( teamNoUsers.getName() );
        team.setCreatedDate( teamNoUsers.getCreatedDate() );
        team.setUsers( userHashSetToUserNoTeamsHashSet( teamNoUsers.getUsers() ) );

        return team;
    }

    protected Collection<Team> teamNoUsersCollectionToTeamCollection(Collection<TeamNoUsers> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<Team> collection1 = new ArrayList<Team>( collection.size() );
        for ( TeamNoUsers teamNoUsers : collection ) {
            collection1.add( teamNoUsersToTeam( teamNoUsers ) );
        }

        return collection1;
    }

    protected HashSet<User> userNoTeamsHashSetToUserHashSet(HashSet<UserNoTeams> hashSet) {
        if ( hashSet == null ) {
            return null;
        }

        HashSet<User> hashSet1 = new HashSet<User>();
        for ( UserNoTeams userNoTeams : hashSet ) {
            hashSet1.add( mapFromNoTeams( userNoTeams ) );
        }

        return hashSet1;
    }

    protected TeamNoUsers teamToTeamNoUsers(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamNoUsers teamNoUsers = new TeamNoUsers();

        teamNoUsers.setId( team.getId() );
        teamNoUsers.setName( team.getName() );
        teamNoUsers.setCreatedDate( team.getCreatedDate() );
        teamNoUsers.setUsers( userNoTeamsHashSetToUserHashSet( team.getUsers() ) );

        return teamNoUsers;
    }

    protected Collection<TeamNoUsers> teamCollectionToTeamNoUsersCollection(Collection<Team> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<TeamNoUsers> collection1 = new ArrayList<TeamNoUsers>( collection.size() );
        for ( Team team : collection ) {
            collection1.add( teamToTeamNoUsers( team ) );
        }

        return collection1;
    }
}
