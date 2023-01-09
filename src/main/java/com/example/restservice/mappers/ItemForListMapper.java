package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.ItemForList;
import com.example.restservice.models.ItemModel;

@Mapper(componentModel = "spring", uses = {UserNoTeamsMapper.class, ColumnMapper.class})
public interface ItemForListMapper {
	ItemForListMapper INSTANCE = Mappers.getMapper(ItemForListMapper.class);

	ItemForList mapToDto(ItemModel itemModel);

	List<ItemForList> mapToDtos(List<ItemModel> itemModels);

	ItemModel mapFromDto(ItemForList itemDto);

	List<ItemModel> mapFromDtos(List<ItemForList> itemDtos);

}
