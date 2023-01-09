package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.CommentForList;
import com.example.restservice.models.CommentModel;

@Mapper(componentModel = "spring", uses = { UserNoTeamsMapper.class, ItemForListMapper.class })
public interface CommentForListMapper {

	CommentForListMapper INSTANCE = Mappers.getMapper(CommentForListMapper.class);

	CommentForList mapToDto(CommentModel commentModel);

	List<CommentForList> mapToDtos(List<CommentModel> commentModels);

	CommentModel mapFromDto(CommentForList commentDto);

	List<CommentModel> mapFromDtos(List<CommentForList> commentDtos);

}
