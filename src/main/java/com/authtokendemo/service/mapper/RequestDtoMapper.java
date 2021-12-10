package com.authtokendemo.service.mapper;

public interface RequestDtoMapper<R, M> {
    M mapToModel(R dto);
}
