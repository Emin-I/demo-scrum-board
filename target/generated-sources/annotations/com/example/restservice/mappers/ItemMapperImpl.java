package com.example.restservice.mappers;

import com.example.restservice.dtos.ColumnNoItem;
import com.example.restservice.dtos.Item;
import com.example.restservice.dtos.Team;
import com.example.restservice.dtos.TeamNoUsers;
import com.example.restservice.dtos.User;
import com.example.restservice.dtos.UserNoTeams;
import com.example.restservice.models.ColumnModel;
import com.example.restservice.models.ItemModel;
import com.example.restservice.models.TeamModel;
import com.example.restservice.models.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-06T15:42:42+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Autowired
    private UserNoTeamsMapper userNoTeamsMapper;

    @Override
    public Item mapToDto(ItemModel itemModel) {
        if ( itemModel == null ) {
            return null;
        }

        Item item = new Item();

        item.setId( itemModel.getId() );
        item.setBody( itemModel.getBody() );
        item.setTitle( itemModel.getTitle() );
        item.setDueDate( itemModel.getDueDate() );
        item.setUser( userModelToUser( itemModel.getUser() ) );
        item.setColumn( columnModelToColumnNoItem( itemModel.getColumn() ) );

        return item;
    }

    @Override
    public List<Item> mapToDtos(List<ItemModel> itemModels) {
        if ( itemModels == null ) {
            return null;
        }

        List<Item> list = new ArrayList<Item>( itemModels.size() );
        for ( ItemModel itemModel : itemModels ) {
            list.add( mapToDto( itemModel ) );
        }

        return list;
    }

    @Override
    public ItemModel mapFromDto(Item itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        ItemModel itemModel = new ItemModel();

        itemModel.setColumn( columnNoItemToColumnModel( itemDto.getColumn() ) );
        itemModel.setUser( userToUserModel( itemDto.getUser() ) );
        itemModel.setDueDate( itemDto.getDueDate() );
        itemModel.setTitle( itemDto.getTitle() );
        itemModel.setId( itemDto.getId() );
        itemModel.setBody( itemDto.getBody() );

        return itemModel;
    }

    @Override
    public List<ItemModel> mapFromDtos(List<Item> itemDtos) {
        if ( itemDtos == null ) {
            return null;
        }

        List<ItemModel> list = new ArrayList<ItemModel>( itemDtos.size() );
        for ( Item item : itemDtos ) {
            list.add( mapFromDto( item ) );
        }

        return list;
    }

    protected HashSet<User> userModelSetToUserHashSet(Set<UserModel> set) {
        if ( set == null ) {
            return null;
        }

        HashSet<User> hashSet = new HashSet<User>();
        for ( UserModel userModel : set ) {
            hashSet.add( userModelToUser( userModel ) );
        }

        return hashSet;
    }

    protected TeamNoUsers teamModelToTeamNoUsers(TeamModel teamModel) {
        if ( teamModel == null ) {
            return null;
        }

        TeamNoUsers teamNoUsers = new TeamNoUsers();

        teamNoUsers.setId( teamModel.getId() );
        teamNoUsers.setName( teamModel.getName() );
        teamNoUsers.setCreatedDate( teamModel.getCreatedDate() );
        teamNoUsers.setUsers( userModelSetToUserHashSet( teamModel.getUsers() ) );

        return teamNoUsers;
    }

    protected Collection<TeamNoUsers> teamModelCollectionToTeamNoUsersCollection(Collection<TeamModel> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<TeamNoUsers> collection1 = new ArrayList<TeamNoUsers>( collection.size() );
        for ( TeamModel teamModel : collection ) {
            collection1.add( teamModelToTeamNoUsers( teamModel ) );
        }

        return collection1;
    }

    protected User userModelToUser(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        User user = new User();

        user.setId( userModel.getId() );
        user.setFirstName( userModel.getFirstName() );
        user.setUsername( userModel.getUsername() );
        user.setLastName( userModel.getLastName() );
        user.setMail( userModel.getMail() );
        user.setAge( userModel.getAge() );
        user.setPassword( userModel.getPassword() );
        user.setTeams( teamModelCollectionToTeamNoUsersCollection( userModel.getTeams() ) );

        return user;
    }

    protected HashSet<UserNoTeams> userModelSetToUserNoTeamsHashSet(Set<UserModel> set) {
        if ( set == null ) {
            return null;
        }

        HashSet<UserNoTeams> hashSet = new HashSet<UserNoTeams>();
        for ( UserModel userModel : set ) {
            hashSet.add( userNoTeamsMapper.mapToDto( userModel ) );
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

    protected ColumnNoItem columnModelToColumnNoItem(ColumnModel columnModel) {
        if ( columnModel == null ) {
            return null;
        }

        ColumnNoItem columnNoItem = new ColumnNoItem();

        columnNoItem.setId( columnModel.getId() );
        columnNoItem.setName( columnModel.getName() );
        columnNoItem.setColour( columnModel.getColour() );
        columnNoItem.setSequence( columnModel.getSequence() );
        columnNoItem.setTeam( teamModelToTeam( columnModel.getTeam() ) );

        return columnNoItem;
    }

    protected Set<UserModel> userNoTeamsHashSetToUserModelSet(HashSet<UserNoTeams> hashSet) {
        if ( hashSet == null ) {
            return null;
        }

        Set<UserModel> set = new LinkedHashSet<UserModel>( Math.max( (int) ( hashSet.size() / .75f ) + 1, 16 ) );
        for ( UserNoTeams userNoTeams : hashSet ) {
            set.add( userNoTeamsMapper.mapFromDto( userNoTeams ) );
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

    protected ColumnModel columnNoItemToColumnModel(ColumnNoItem columnNoItem) {
        if ( columnNoItem == null ) {
            return null;
        }

        ColumnModel columnModel = new ColumnModel();

        columnModel.setTeam( teamToTeamModel( columnNoItem.getTeam() ) );
        columnModel.setId( columnNoItem.getId() );
        columnModel.setName( columnNoItem.getName() );
        columnModel.setColour( columnNoItem.getColour() );
        columnModel.setSequence( columnNoItem.getSequence() );

        return columnModel;
    }

    protected Set<UserModel> userHashSetToUserModelSet(HashSet<User> hashSet) {
        if ( hashSet == null ) {
            return null;
        }

        Set<UserModel> set = new LinkedHashSet<UserModel>( Math.max( (int) ( hashSet.size() / .75f ) + 1, 16 ) );
        for ( User user : hashSet ) {
            set.add( userToUserModel( user ) );
        }

        return set;
    }

    protected TeamModel teamNoUsersToTeamModel(TeamNoUsers teamNoUsers) {
        if ( teamNoUsers == null ) {
            return null;
        }

        TeamModel teamModel = new TeamModel();

        teamModel.setUsers( userHashSetToUserModelSet( teamNoUsers.getUsers() ) );
        teamModel.setId( teamNoUsers.getId() );
        teamModel.setName( teamNoUsers.getName() );
        teamModel.setCreatedDate( teamNoUsers.getCreatedDate() );

        return teamModel;
    }

    protected Collection<TeamModel> teamNoUsersCollectionToTeamModelCollection(Collection<TeamNoUsers> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<TeamModel> collection1 = new ArrayList<TeamModel>( collection.size() );
        for ( TeamNoUsers teamNoUsers : collection ) {
            collection1.add( teamNoUsersToTeamModel( teamNoUsers ) );
        }

        return collection1;
    }

    protected UserModel userToUserModel(User user) {
        if ( user == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setTeams( teamNoUsersCollectionToTeamModelCollection( user.getTeams() ) );
        userModel.setId( user.getId() );
        userModel.setFirstName( user.getFirstName() );
        userModel.setLastName( user.getLastName() );
        userModel.setMail( user.getMail() );
        userModel.setAge( user.getAge() );
        userModel.setUsername( user.getUsername() );
        userModel.setPassword( user.getPassword() );

        return userModel;
    }
}
