package com.example.restservice.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.restservice.dtos.*;
import com.example.restservice.models.*;

@Mapper(componentModel = "spring", uses = { RoleMapper.class })
public interface PrivilegeMapper {

	PrivilegeMapper INSTANCE = Mappers.getMapper(PrivilegeMapper.class);

	Privilege mapToDto(PrivilegeModel privilegeModel);

	List<Privilege> mapToDtos(List<PrivilegeModel> privilegeModels);

	PrivilegeModel mapFromDto(Privilege privilegeDto);

	List<PrivilegeModel> mapFromDtos(List<Privilege> privilegeDtos);

}
