//package repository;
//
//public interface SegmentRepository {
//
//}
// SegmentRepository.java
package com.example.transcript_tagging_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transcript_tagging_system.model.Segment;

public interface SegmentRepository extends JpaRepository<Segment, Long> {
}
