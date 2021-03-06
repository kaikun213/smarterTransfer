package com.smarter_transfer.springrest.registration.user.web;

import common.app.model.Location;
import common.app.model.user.User;

/**
 * Data Transfer Object (DTO) for {@link User}
 * @author kaikun
 *
 */
public class UserDTO {
	
	private long userId = 0;
	private String name;
	private Location location;
	private String deviceId;
	private long themeId;
	
	public UserDTO(){};
	
	public UserDTO(User user){
		this.userId = user.getUserId();
		this.name = user.getName();
		this.deviceId = user.getDeviceId();
		this.setLocation(user.getLocation());
		if (user.getTheme() != null){
			this.themeId = user.getTheme().getThemeId();
		}
	}
	
	public long getUserId(){
		return userId;
	}

	public String getName() {
		return name;
	}

	public long getThemeId() {
		return themeId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
