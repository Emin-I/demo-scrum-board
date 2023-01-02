package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.*;
import com.example.restservice.models.*;

@Mapper(componentModel = "spring")
public interface TeamMapper {

	TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

	Team mapToDto(TeamModel teamModel);

	List<Team> mapToDtos(List<TeamModel> teamModels);

	TeamModel mapFromDto(Team teamDto);

	List<TeamModel> mapFromDtos(List<Team> teamDtos);
}
