package com.example.restservice.mappers;

import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.*;

public interface ItemDtoDtoMapper {

	ItemDtoDtoMapper INSTANCE = Mappers.getMapper(ItemDtoDtoMapper.class);

	ItemNoComments mapToNoComments(Item item);

	Item mapFromNoComments(ItemNoComments itemNoComments);
}
