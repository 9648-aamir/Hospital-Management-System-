package com.qspidsers.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qspidsers.hospital_management_system.dao.RoomDao;
import com.qspidsers.hospital_management_system.entity.Room;

@RestController
@RequestMapping("/roomController")
public class RoomController {

	@Autowired
	private RoomDao roomDao;
	
	@PostMapping("/saveAllRoom")
	public List<Room> saveAllRoomDao(@RequestBody List<Room> room) {
		return roomDao.saveAllRoomDao(room);
	}
	
	@PostMapping("/updateRoom/{id}")
	public Room updateRoomDao(@PathVariable(name="id") int id,@RequestBody Room updateRoom) {
		return roomDao.updateRoomDao(id, updateRoom);
	}
	
	@GetMapping("/getAllRoom")
	public List<Room> getAllRoomDao(){
		return roomDao.getAllRoomDao();
	}
	
	@GetMapping("/getRoomById/{id}")
	public Room getRoomByIdDao(@PathVariable(name = "id") int id) {
		return roomDao.getRoomByIdDao(id);
	}
	
	@DeleteMapping("/deleteRoomByIdD/{id}")
	public Room deleteRoomByIdDao(@PathVariable(name="id") int id) {
		return roomDao.deleteRoomByIdDao(id);
	}
}
