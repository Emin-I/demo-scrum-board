package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.ColumnForList;
import com.example.restservice.models.ColumnModel;

@Mapper(componentModel = "spring", uses = { ItemForListMapper.class, TeamNoUsersMapper.class })
public interface ColumnForListMapper {

	ColumnForListMapper INSTANCE = Mappers.getMapper(ColumnForListMapper.class);

	ColumnForList mapToDto(ColumnModel columnModel);

	List<ColumnForList> mapToDtos(List<ColumnModel> columnModels);

	ColumnModel mapFromDto(ColumnForList columnDto);

	List<ColumnModel> mapFromDtos(List<ColumnForList> columnDtos);

}
