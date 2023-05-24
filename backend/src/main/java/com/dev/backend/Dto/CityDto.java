package com.dev.backend.Dto;

import com.dev.backend.entity.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    Long id;
    String name;
    State state;
    Long stateId;

    public CityDto(Long id, String name, Long stateId) {
        this.id = id;
        this.name = name;
        this.stateId = stateId;
    }
}
