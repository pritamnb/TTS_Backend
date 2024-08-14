//package repository;
//
//public interface TagRepository {
//
//}
// TagRepository.java
package com.example.transcript_tagging_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transcript_tagging_system.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
	List<Tag> findBySegmentId(Long segmentId);
}
