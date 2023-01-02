package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.*;
import com.example.restservice.models.*;

@Mapper(componentModel = "spring")
public interface TeamNoUsersMapper {

	TeamNoUsersMapper INSTANCE = Mappers.getMapper(TeamNoUsersMapper.class);

	@Mapping(target = "users", ignore = true)
	TeamNoUsers mapToDto(TeamModel teamModel);

	@Mapping(target = "users", ignore = true)
	List<TeamNoUsers> mapToDtos(List<TeamModel> teamModels);

	@Mapping(target = "users", ignore = true)
	TeamModel mapFromDto(TeamNoUsers teamDto);

	@Mapping(target = "users", ignore = true)
	List<TeamModel> mapFromDtos(List<TeamNoUsers> teamDtos);
}
