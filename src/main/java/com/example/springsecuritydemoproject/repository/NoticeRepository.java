package com.example.springsecuritydemoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecuritydemoproject.model.Notice;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {

	@Query(value = "from Notice n")
	List<Notice> findAllNotices();

}
