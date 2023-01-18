package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.ColumnNoItem;
import com.example.restservice.models.ColumnModel;

@Mapper(componentModel = "spring", uses = { ItemForListMapper.class, TeamNoUsersMapper.class, UserNoTeamsMapper.class })
public interface ColumnNoItemMapper {

	ColumnNoItemMapper INSTANCE = Mappers.getMapper(ColumnNoItemMapper.class);

	ColumnNoItem mapToDto(ColumnModel columnModel);

	List<ColumnNoItem> mapToDtos(List<ColumnModel> columnModels);

	ColumnModel mapFromDto(ColumnNoItem columnDto);

	List<ColumnModel> mapFromDtos(List<ColumnNoItem> columnDtos);

}
