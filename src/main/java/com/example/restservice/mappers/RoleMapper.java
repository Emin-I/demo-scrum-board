package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.Role;
import com.example.restservice.models.RoleModel;

@Mapper(componentModel = "spring", uses = { PrivilegeMapper.class, UserNoTeamsMapper.class })
public interface RoleMapper {

	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

	Role mapToDto(RoleModel roleModel);

	List<Role> mapToDtos(List<RoleModel> roleModels);

	RoleModel mapFromDto(Role roleDto);

	List<RoleModel> mapFromDtos(List<Role> roleDtos);

}
