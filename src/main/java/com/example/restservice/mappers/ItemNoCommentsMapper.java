package com.example.restservice.mappers;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.restservice.dtos.ItemNoComments;
import com.example.restservice.models.ItemModel;

public interface ItemNoCommentsMapper {

	ItemNoCommentsMapper INSTANCE = Mappers.getMapper(ItemNoCommentsMapper.class);

	@Mapping(target = "comment", ignore = true)
	ItemNoComments mapToDto(ItemModel itemModel);

	@Mapping(target = "comment", ignore = true)
	List<ItemNoComments> mapToDtos(List<ItemModel> itemModels);

	@Mapping(target = "comment", ignore = true)
	ItemModel mapFromDto(ItemNoComments itemDto);

	@Mapping(target = "comment", ignore = true)
	List<ItemModel> mapFromDtos(List<ItemNoComments> itemDtos);
}
