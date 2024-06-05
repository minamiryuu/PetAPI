package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.pets.Category;
import com.example.demo.pets.Pet;
import com.example.demo.pets.Tags;

@Service
public class PetService {

	private List<Pet>allPets = new ArrayList<> (Arrays.asList(
			new Pet("id", new Category("id", "name"), "name", 
					Arrays.asList("photoUrls"), 
					Arrays.asList(new Tags("id", "name")), "status")));
	
	public List<Pet> getPets() {
		return allPets;
	}

	public void postPet(Pet pet) {
		allPets.add(pet);
	}
	
	public void updatePet(Pet pet) {
		for(int i = 0; i < allPets.size(); i++) {
			if(allPets.get(i).getId().equals(pet.getId())) {
				allPets.get(i).setId(pet.getId());
				allPets.get(i).setCategory(pet.getCategory());
				allPets.get(i).setName(pet.getName());
				allPets.get(i).setPhotoUrls(pet.getPhotoUrls());
				allPets.get(i).setTags(pet.getTags());
				allPets.get(i).setStatus(pet.getStatus());
			}
		}
	}
	
	public List<Pet> getSameStatusPet(String status) {
		List<Pet>chosenPets = new ArrayList<>();
		for(int i = 0; i < allPets.size(); i++) {
			if(allPets.get(i).getStatus().equals(status)) {
				chosenPets.add(allPets.get(i));
			}
		}
		return chosenPets;
	}
	
	public List<Pet> getSameTagPet(String tagsId, String tagsName) {
		List<Pet>chosenPets = new ArrayList<>();
		for(int i = 0; i < allPets.size(); i++) {
			List<Tags> petTags = allPets.get(i).getTags();
			for(int j = 0; j < petTags.size(); j++) {
				Tags petTag = petTags.get(j);
				if(petTag.getId().equals(tagsId) && 
					petTag.getName().equals(tagsName)) {
					chosenPets.add(allPets.get(i));
					break;
				}
			}
		}
		return chosenPets;
	}
	
	public Pet getSameIdPet(String id) {
		for(int i = 0; i < allPets.size(); i++) {
			if(allPets.get(i).getId().equals(id)) {
				return allPets.get(i);
			}
		}
		return null; 
	}
	
	public void postSameIdPet(String id, Pet pet) {
		for(int i = 0; i < allPets.size(); i++) {
			if(allPets.get(i).getId().equals(id)) {
				allPets.get(i).setId(pet.getId());
				allPets.get(i).setCategory(pet.getCategory());
				allPets.get(i).setName(pet.getName());
				allPets.get(i).setPhotoUrls(pet.getPhotoUrls());
				allPets.get(i).setTags(pet.getTags());
				allPets.get(i).setStatus(pet.getStatus());
			}
		}
	}
	
	public void deleteSameIdPet(String id) {
		for(int i = 0; i < allPets.size(); i++) {
			if(allPets.get(i).getId().equals(id)) {
				allPets.remove(i);
			}
		}
	}
	
}
