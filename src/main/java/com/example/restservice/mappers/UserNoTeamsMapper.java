package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.*;
import com.example.restservice.models.*;

@Mapper(componentModel = "spring")
public interface UserNoTeamsMapper {

	UserNoTeamsMapper INSTANCE = Mappers.getMapper(UserNoTeamsMapper.class);

	@Mapping(target = "teams", ignore = true)
	UserNoTeams mapToDto(UserModel userModel);

	@Mapping(target = "teams", ignore = true)
	List<UserNoTeams> mapToDtos(List<UserModel> userModels);

	@Mapping(target = "teams", ignore = true)
	UserModel mapFromDto(UserNoTeams userDto);

	@Mapping(target = "teams", ignore = true)
	List<UserModel> mapFromDtos(List<UserNoTeams> userDtos);

}
