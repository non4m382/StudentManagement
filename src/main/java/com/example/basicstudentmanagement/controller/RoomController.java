package com.example.basicstudentmanagement.controller;

import com.example.basicstudentmanagement.mapper.RoomMapper;
import com.example.basicstudentmanagement.service.dto.RoomDTO;
import com.example.basicstudentmanagement.service.impl.RoomServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    private final RoomServiceImpl roomService;
    RoomMapper mapper;

    public RoomController(RoomServiceImpl roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<RoomDTO> getAllRooms() {
        return roomService.getAllRooms().stream().map(room -> mapper.INSTANCE.entityToDTO(room))
                .collect(Collectors.toList());
    }

//    @GetMapping
//    public List<Room> getAllRoomss() {
//        return roomService.getAllRooms();
//    }

    @GetMapping("/{id}")
    public RoomDTO getRoomById(@PathVariable Long id) {
        return mapper.INSTANCE.entityToDTO(roomService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addRoom(@Valid @RequestBody RoomDTO roomDTO) {
        roomService.saveRoom(mapper.INSTANCE.DTOToEntity(roomDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable Long id) {
        roomService.deleteRoomById(id);
    }
}
