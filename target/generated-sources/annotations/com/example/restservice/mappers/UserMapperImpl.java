package com.example.restservice.mappers;

import com.example.restservice.dtos.User;
import com.example.restservice.models.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-22T12:40:57+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToDto(UserModel userModel) {
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

        return user;
    }

    @Override
    public List<User> mapToDtos(List<UserModel> userModels) {
        if ( userModels == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userModels.size() );
        for ( UserModel userModel : userModels ) {
            list.add( mapToDto( userModel ) );
        }

        return list;
    }

    @Override
    public UserModel mapFromDto(User userDto) {
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
    public List<UserModel> mapFromDtos(List<User> userDtos) {
        if ( userDtos == null ) {
            return null;
        }

        List<UserModel> list = new ArrayList<UserModel>( userDtos.size() );
        for ( User user : userDtos ) {
            list.add( mapFromDto( user ) );
        }

        return list;
    }
}
