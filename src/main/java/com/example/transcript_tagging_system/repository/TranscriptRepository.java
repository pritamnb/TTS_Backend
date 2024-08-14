//package repository;
//
//public interface TranscriptRepository {
//
//}
// TranscriptRepository.java
package com.example.transcript_tagging_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transcript_tagging_system.model.Transcript;

public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
}
