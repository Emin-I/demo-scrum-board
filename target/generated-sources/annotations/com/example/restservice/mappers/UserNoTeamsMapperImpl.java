package com.example.restservice.mappers;

import com.example.restservice.dtos.UserNoTeams;
import com.example.restservice.models.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-18T09:59:46+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class UserNoTeamsMapperImpl implements UserNoTeamsMapper {

    @Override
    public UserNoTeams mapToDto(UserModel userModel) {
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

        return userNoTeams;
    }

    @Override
    public List<UserNoTeams> mapToDtos(List<UserModel> userModels) {
        if ( userModels == null ) {
            return null;
        }

        List<UserNoTeams> list = new ArrayList<UserNoTeams>( userModels.size() );
        for ( UserModel userModel : userModels ) {
            list.add( mapToDto( userModel ) );
        }

        return list;
    }

    @Override
    public UserModel mapFromDto(UserNoTeams userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userDto.getId() );
        userModel.setFirstName( userDto.getFirstName() );
        userModel.setLastName( userDto.getLastName() );
        userModel.setMail( userDto.getMail() );
        userModel.setAge( userDto.getAge() );
        userModel.setUsername( userDto.getUsername() );
        userModel.setPassword( userDto.getPassword() );

        return userModel;
    }

    @Override
    public List<UserModel> mapFromDtos(List<UserNoTeams> userDtos) {
        if ( userDtos == null ) {
            return null;
        }

        List<UserModel> list = new ArrayList<UserModel>( userDtos.size() );
        for ( UserNoTeams userNoTeams : userDtos ) {
            list.add( mapFromDto( userNoTeams ) );
        }

        return list;
    }
}
