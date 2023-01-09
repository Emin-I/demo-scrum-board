package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.Comment;
import com.example.restservice.models.CommentModel;

@Mapper(componentModel = "spring")
public interface CommentMapper {

	CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

	Comment mapToDto(CommentModel commentModel);

	List<Comment> mapToDtos(List<CommentModel> commentModels);

	CommentModel mapFromDto(Comment columnDto);

	List<CommentModel> mapFromDtos(List<Comment> commentDtos);
}
