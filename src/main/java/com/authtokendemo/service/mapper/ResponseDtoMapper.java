package com.authtokendemo.service.mapper;

public interface ResponseDtoMapper<R, M> {
    R mapToDto(M t);
}
