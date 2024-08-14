//package service;
//
//public class TranscriptService {
//
//}
// TranscriptService.java
package com.example.transcript_tagging_system.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.transcript_tagging_system.model.Segment;
import com.example.transcript_tagging_system.model.Transcript;
import com.example.transcript_tagging_system.repository.SegmentRepository;
import com.example.transcript_tagging_system.repository.TranscriptRepository;
import com.example.transcript_tagging_system.util.SrtParser;

@Service
public class TranscriptService {


	 @Autowired
	 private SegmentRepository segmentRepository;

	 public List<Segment> saveTranscript(MultipartFile file) {
		 try {
	            List<Segment> segments = SrtParser.parseSrtFile(file);
	            return segmentRepository.saveAll(segments);
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to parse SRT file", e);
	        }
	    }

	    public Segment getTranscript(Long id) {
	        return segmentRepository.findById(id).orElse(null);
	    }
	    public List<Segment> getAllTranscript() {
	        return segmentRepository.findAll();
	    }
	 
	    }
