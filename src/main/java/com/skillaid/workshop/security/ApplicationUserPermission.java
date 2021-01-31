package com.skillaid.workshop.security;

public enum ApplicationUserPermission {
	REGISTRATIONS_READ("registrations:read"), 
	REGISTRATIONS_EDIT("registrations:edit");

	private final String permission;

	ApplicationUserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}