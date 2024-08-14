package com.example.transcript_tagging_system.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transcript_tagging_system.model.Tag;
import com.example.transcript_tagging_system.repository.TagRepository;

@Service
public class TagService {

	@Autowired
    private TagRepository tagRepository;

    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    public Tag getTag(Long id) {
        return tagRepository.findById(id).orElse(null);
    }
    public List<Tag> getAllTag() {
        return tagRepository.findAll();
    }
    
    public List<Tag> getTagsBySegment(Long segmentId) {
        return tagRepository.findBySegmentId(segmentId);
    }
}
