package com.example.restservice.mappers;

import com.example.restservice.dtos.TeamNoUsers;
import com.example.restservice.models.TeamModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-22T12:40:57+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class TeamNoUsersMapperImpl implements TeamNoUsersMapper {

    @Override
    public TeamNoUsers mapToDto(TeamModel teamModel) {
        if ( teamModel == null ) {
            return null;
        }

        TeamNoUsers teamNoUsers = new TeamNoUsers();

        teamNoUsers.setId( teamModel.getId() );
        teamNoUsers.setName( teamModel.getName() );
        teamNoUsers.setCreatedDate( teamModel.getCreatedDate() );

        return teamNoUsers;
    }

    @Override
    public List<TeamNoUsers> mapToDtos(List<TeamModel> teamModels) {
        if ( teamModels == null ) {
            return null;
        }

        List<TeamNoUsers> list = new ArrayList<TeamNoUsers>( teamModels.size() );
        for ( TeamModel teamModel : teamModels ) {
            list.add( mapToDto( teamModel ) );
        }

        return list;
    }

    @Override
    public TeamModel mapFromDto(TeamNoUsers teamDto) {
        if ( teamDto == null ) {
            return null;
        }

        TeamModel teamModel = new TeamModel();

        teamModel.setId( teamDto.getId() );
        teamModel.setName( teamDto.getName() );
        teamModel.setCreatedDate( teamDto.getCreatedDate() );

        return teamModel;
    }

    @Override
    public List<TeamModel> mapFromDtos(List<TeamNoUsers> teamDtos) {
        if ( teamDtos == null ) {
            return null;
        }

        List<TeamModel> list = new ArrayList<TeamModel>( teamDtos.size() );
        for ( TeamNoUsers teamNoUsers : teamDtos ) {
            list.add( mapFromDto( teamNoUsers ) );
        }

        return list;
    }
}
