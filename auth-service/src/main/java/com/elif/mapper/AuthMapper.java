package com.elif.mapper;

import com.elif.dto.request.RegisterRequestDto;
import com.elif.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    Auth fromRegisterAuthDtoToAuth(RegisterRequestDto dto);

}
