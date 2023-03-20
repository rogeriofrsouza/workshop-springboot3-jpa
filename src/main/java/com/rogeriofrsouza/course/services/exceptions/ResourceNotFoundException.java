package com.rogeriofrsouza.course.services.exceptions;

// Exceção personalizada da camada de Service
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// Recebe o id do objeto que não foi encontrado
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}
}
