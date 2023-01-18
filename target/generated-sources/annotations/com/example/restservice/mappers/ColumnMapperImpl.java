package com.example.restservice.mappers;

import com.example.restservice.dtos.Column;
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
    date = "2023-01-18T09:59:46+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class ColumnMapperImpl implements ColumnMapper {

    @Autowired
    private TeamNoUsersMapper teamNoUsersMapper;

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
        if ( column.getItems() != null ) {
            List<Item> list = itemModelListToItemList( columnModel.getItems() );
            if ( list != null ) {
                column.getItems().addAll( list );
            }
        }

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

        columnModel.setItems( itemListToItemModelList( columnDto.getItems() ) );
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

    protected Collection<TeamNoUsers> teamModelCollectionToTeamNoUsersCollection(Collection<TeamModel> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<TeamNoUsers> collection1 = new ArrayList<TeamNoUsers>( collection.size() );
        for ( TeamModel teamModel : collection ) {
            collection1.add( teamNoUsersMapper.mapToDto( teamModel ) );
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

    protected Item itemModelToItem(ItemModel itemModel) {
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

    protected List<Item> itemModelListToItemList(List<ItemModel> list) {
        if ( list == null ) {
            return null;
        }

        List<Item> list1 = new ArrayList<Item>( list.size() );
        for ( ItemModel itemModel : list ) {
            list1.add( itemModelToItem( itemModel ) );
        }

        return list1;
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

    protected Collection<TeamModel> teamNoUsersCollectionToTeamModelCollection(Collection<TeamNoUsers> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<TeamModel> collection1 = new ArrayList<TeamModel>( collection.size() );
        for ( TeamNoUsers teamNoUsers : collection ) {
            collection1.add( teamNoUsersMapper.mapFromDto( teamNoUsers ) );
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

    protected ItemModel itemToItemModel(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemModel itemModel = new ItemModel();

        itemModel.setColumn( columnNoItemToColumnModel( item.getColumn() ) );
        itemModel.setUser( userToUserModel( item.getUser() ) );
        itemModel.setDueDate( item.getDueDate() );
        itemModel.setTitle( item.getTitle() );
        itemModel.setId( item.getId() );
        itemModel.setBody( item.getBody() );

        return itemModel;
    }

    protected List<ItemModel> itemListToItemModelList(List<Item> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemModel> list1 = new ArrayList<ItemModel>( list.size() );
        for ( Item item : list ) {
            list1.add( itemToItemModel( item ) );
        }

        return list1;
    }
}
