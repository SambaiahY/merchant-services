package com.sptech.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sptech.entities.Admin;

@Repository
public interface AdminRepositories extends CrudRepository<Admin, String> {

	public Admin findByUserNameAndPassword(String userName, String password);
}
