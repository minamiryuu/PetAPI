package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pets.Pet;
import com.example.demo.service.PetService;

@RestController
public class PetController {

	@Autowired
	private PetService petService;
	
	@GetMapping("/pet")
	public List<Pet> getAllPet() {
        return petService.getPets();
    }
	
	@PostMapping("/pet")
	public void postPet(@RequestBody Pet pet) {
        petService.postPet(pet);
    }
	
	@PutMapping("/pet")
	public void updatePet(@RequestBody Pet pet) {
		petService.updatePet(pet);
    }
	
	@GetMapping("/pet/findByStatus")
	public List<Pet> getSameStatusPet(@RequestParam("status") String status) {
		return petService.getSameStatusPet(status);
    }
	
	@GetMapping("/pet/findByTags")
	public List<Pet> getSameTagPet(@RequestParam("TagsId") String tagsId, 
								   @RequestParam("TagsName") String tagsName) {
		return petService.getSameTagPet(tagsId, tagsName);
    }
	
	@GetMapping("/pet/{petId}")
	public Pet getSameIdPet(@PathVariable("petId") String id) {
		return petService.getSameIdPet(id);
    }
	
	@PostMapping("/pet/{petId}")
	public void postSameIdPet(@PathVariable("petId") String id, @RequestBody Pet pet) {
		petService.postSameIdPet(id, pet);
    }
	
	@DeleteMapping("/pet/{petId}")
	public void deleteSameIdPet(@PathVariable("petId") String id) {
		petService.deleteSameIdPet(id);
    }
	
}
