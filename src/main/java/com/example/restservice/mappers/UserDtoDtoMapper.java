package com.example.restservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.*;

@Mapper(componentModel = "spring")
public interface UserDtoDtoMapper {

	UserDtoDtoMapper INSTANCE = Mappers.getMapper(UserDtoDtoMapper.class);

	UserNoTeams mapToNoTeams(User user);

	User mapFromNoTeams(UserNoTeams userNoTeams);

}
