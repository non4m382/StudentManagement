package com.example.basicstudentmanagement.mapper;

import com.example.basicstudentmanagement.model.Room;
import com.example.basicstudentmanagement.service.dto.RoomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper extends BaseMapper<Room, RoomDTO> {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

////    @Mapping(target = "id", source = "id")
////    @Mapping(target = "name", source = "name")
////    @Mapping(target = "quantity", source = "quantity")
//    RoomDTO roomToRoomDTO(Room entity);
//
////    @Mapping(target = "id", source = "id")
////    @Mapping(target = "name", source ="name")
////    @Mapping(target = "quantity", source = "quantity")
////    Room roomDTOToRoom(RoomDTO roomDTO);
}
