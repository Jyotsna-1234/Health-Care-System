package org.com.capg.healthcare.dao;

import java.util.List;

import org.com.capg.healthcare.entity.TestCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCenterRepository extends JpaRepository<TestCenter, String> {

	@Query(value = "from TestCenter tc where tc.center.centerId=:cid")
	public List<TestCenter> viewTest(@Param("cid") String centerId );
	
	@Query(value = "from TestCenter tc where tc.test.testId=:tid")
	public List<TestCenter> viewCenter(@Param("tid") String testId);
	
}

