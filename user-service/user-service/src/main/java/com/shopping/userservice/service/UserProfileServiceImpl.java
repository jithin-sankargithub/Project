package com.shopping.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.userservice.model.UserProfile;
import com.shopping.userservice.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public void addNewUserProfile(UserProfile userProfile) {
		   userProfileRepository.save(userProfile);
	}

	@Override
	public Optional<UserProfile> getById(String id) {
		return userProfileRepository.findById(id);
	}

	@Override
	public void updateProfile(UserProfile userProfile) {
		 userProfileRepository.save(userProfile);
	}
	
	@Override
	public Optional<UserProfile> getUserByEmail(String email) {
		return userProfileRepository.getUserByEmail(email);
	}

}
