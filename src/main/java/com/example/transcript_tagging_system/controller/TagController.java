package com.example.transcript_tagging_system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.transcript_tagging_system.model.Tag;
import com.example.transcript_tagging_system.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        Tag createdTag = tagService.saveTag(tag);
        return ResponseEntity.ok(createdTag);
    }
    @GetMapping("")
    public ResponseEntity<List<Tag>> getAllTags(){
    	List<Tag> tags = tagService.getAllTag();
    	return ResponseEntity.ok(tags);
    }

    @GetMapping("/{segmentId}")
    public ResponseEntity<List<Tag>> getTagsBySegment(@PathVariable Long segmentId) {
        List<Tag> tags = tagService.getTagsBySegment(segmentId);
        return ResponseEntity.ok(tags);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}
