package org.com.capg.healthcare.dao;

import org.com.capg.healthcare.entity.DiagnosticCenter;
import org.com.capg.healthcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface UserRepository extends JpaRepository<User, Long>{

		

	}

