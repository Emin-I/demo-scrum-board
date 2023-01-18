package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.CommentNoRecursion;
import com.example.restservice.models.CommentModel;

@Mapper(componentModel = "spring", uses = { UserNoTeamsMapper.class, ItemForListMapper.class, })
public interface CommentNoRecursionMapper {

	CommentNoRecursionMapper INSTANCE = Mappers.getMapper(CommentNoRecursionMapper.class);

	CommentNoRecursion mapToDto(CommentModel commentModel);

	List<CommentNoRecursion> mapToDtos(List<CommentModel> commentModels);

	CommentModel mapFromDto(CommentNoRecursion commentDto);

	List<CommentModel> mapFromDtos(List<CommentNoRecursion> commentDtos);

}
