package com.example.restservice.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.Item;
import com.example.restservice.models.ItemModel;

@Mapper(componentModel = "spring")
public interface ItemMapper {
	ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

	Item mapToDto(ItemModel itemModel);

	List<Item> mapToDtos(List<ItemModel> itemModels);

	ItemModel mapFromDto(Item itemDto);

	List<ItemModel> mapFromDtos(List<Item> itemDtos);

}
