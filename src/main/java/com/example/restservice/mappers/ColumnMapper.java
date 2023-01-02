package com.example.restservice.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.restservice.dtos.Column;
import com.example.restservice.models.ColumnModel;

@Mapper(componentModel = "spring")
public interface ColumnMapper {

	ColumnMapper INSTANCE = Mappers.getMapper(ColumnMapper.class);

	Column mapToDto(ColumnModel columnModel);

	List<Column> mapToDtos(List<ColumnModel> columnModels);

	ColumnModel mapFromDto(Column columnDto);

	List<ColumnModel> mapFromDtos(List<Column> columnDtos);
}
