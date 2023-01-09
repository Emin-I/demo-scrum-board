package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.*;
import com.example.restservice.models.*;

@Mapper(componentModel = "spring", uses = {TeamNoUsersMapper.class})
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User mapToDto(UserModel userModel);

	List<User> mapToDtos(List<UserModel> userModels);

	UserModel mapFromDto(User userDto);

	List<UserModel> mapFromDtos(List<User> userDtos);

}
