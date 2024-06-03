package com.mst.app.mappers;

import com.mst.app.models.AntenaDTO;
import com.mst.app.persistence.entities.Antena;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AntenaMapper {
    Antena antenaModelToAntenaEntity(AntenaDTO antenaModel);

    AntenaDTO antenaEntityToAntenaModel(Antena antenaEntity);
}
