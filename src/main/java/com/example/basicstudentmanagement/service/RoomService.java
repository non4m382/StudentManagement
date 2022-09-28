package com.example.basicstudentmanagement.service;

import com.example.basicstudentmanagement.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();

    Room findById(Long id);
//    SubjectDTO convertEntityToDto(Subject subject);

    Room saveRoom(Room room);

    void deleteRoomById(Long id);
}
