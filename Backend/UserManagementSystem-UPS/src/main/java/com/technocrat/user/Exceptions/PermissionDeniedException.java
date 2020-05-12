package com.technocrat.user.Exceptions;

public class PermissionDeniedException extends Exception {
	public PermissionDeniedException() {
		super("Permission denied for the action");
	}
	public PermissionDeniedException(String message) {
		super(message);
	}
}
