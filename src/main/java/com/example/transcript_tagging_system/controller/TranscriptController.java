
package com.example.transcript_tagging_system.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;

import com.example.transcript_tagging_system.model.Segment;
import com.example.transcript_tagging_system.model.Transcript;
import com.example.transcript_tagging_system.repository.SegmentRepository;
import com.example.transcript_tagging_system.service.TranscriptService;
import com.example.transcript_tagging_system.util.SrtParser;

@RestController
@RequestMapping("/transcripts")
public class TranscriptController {
	 @Autowired
	 private TranscriptService transcriptService;
	 
	 @GetMapping("/test")
	 public String testController() {
		 return "Test controller";
	 }
	 
	 
	 @PostMapping("/upload")
	 public List<Segment> uploadTranscript(@RequestParam("file") MultipartFile file) {
       return transcriptService.saveTranscript(file);
    }
	 @GetMapping("")
	 public List<Segment> getAllTranscript() {
		 return transcriptService.getAllTranscript();
	 }

	 @GetMapping("/{id}")
	 public Segment getTranscript(@PathVariable Long id) {
		 return transcriptService.getTranscript(id);
	 }
}
