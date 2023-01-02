package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.*;
import com.example.restservice.models.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(target = "teams", ignore = true)
	User mapToDto(UserModel userModel);

	@Mapping(target = "teams", ignore = true)
	List<User> mapToDtos(List<UserModel> userModels);

	@Mapping(target = "teams", ignore = true)
	UserModel mapFromDto(User userDto);

	@Mapping(target = "teams", ignore = true)
	List<UserModel> mapFromDtos(List<User> userDtos);

}
