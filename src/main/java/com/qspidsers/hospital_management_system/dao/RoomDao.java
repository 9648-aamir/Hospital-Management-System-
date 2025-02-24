package com.qspidsers.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspidsers.hospital_management_system.entity.Room;
import com.qspidsers.hospital_management_system.repository.RoomRepository;

@Repository
public class RoomDao {

	@Autowired
	private RoomRepository roomRepo;
	
	public List<Room> saveAllRoomDao(List<Room> room) {
		return roomRepo.saveAll(room);
	}
	
	public Room updateRoomDao(int id, Room updateRoom) {
		
		Optional<Room> optional=roomRepo.findById(id);
		
		if(optional.isPresent()) {
			
			Room room=optional.get();
			
			room.setPatient(updateRoom.getPatient());
			room.setRoomNumber(updateRoom.getRoomNumber());
			
			return roomRepo.save(room);
		}else {
			return null;
		}
	}
	
	public List<Room> getAllRoomDao(){
		return roomRepo.findAll();
	}
	
	public Room getRoomByIdDao(int id) {
		return roomRepo.findById(id).orElse(null);
	}
	
	public Room deleteRoomByIdDao(int id) {
		Optional<Room> optional= roomRepo.findById(id);
		
		if(optional.isPresent()) {
			roomRepo.deleteById(id);
			return optional.get();
		}else {
			return null;
		}
	}
}
