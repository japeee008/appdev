package com.appdev.altf4.seloteriog5.service;

import com.appdev.altf4.seloteriog5.entity.KnowledgeBase;
import com.appdev.altf4.seloteriog5.repository.KnowledgeBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeBaseService {

    @Autowired
    private KnowledgeBaseRepository knowledgeBaseRepository;

    // CREATE
    public KnowledgeBase createEntry(KnowledgeBase kb) {
        return knowledgeBaseRepository.save(kb);
    }

    // READ ALL
    public List<KnowledgeBase> getAllEntries() {
        return knowledgeBaseRepository.findAll();
    }

    // READ ONE
    public KnowledgeBase getEntryById(Long id) {
        return knowledgeBaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KnowledgeBase entry not found with id " + id));
    }

    // UPDATE
    public KnowledgeBase updateEntry(Long id, KnowledgeBase updated) {
        KnowledgeBase existing = getEntryById(id);

        if (updated.getCategoryId() != null) {
            existing.setCategoryId(updated.getCategoryId());
        }
        if (updated.getDepartmentId() != null) {
            existing.setDepartmentId(updated.getDepartmentId());
        }
        if (updated.getTitle() != null) {
            existing.setTitle(updated.getTitle());
        }
        if (updated.getQuestionPattern() != null) {
            existing.setQuestionPattern(updated.getQuestionPattern());
        }
        if (updated.getAnswer() != null) {
            existing.setAnswer(updated.getAnswer());
        }
        if (updated.getIsPublished() != null) {
            existing.setIsPublished(updated.getIsPublished());
        }
        if (updated.getUpdatedBy() != null) {
            existing.setUpdatedBy(updated.getUpdatedBy());
        }

        return knowledgeBaseRepository.save(existing);
    }

    // DELETE
    public void deleteEntry(Long id) {
        if (!knowledgeBaseRepository.existsById(id)) {
            throw new RuntimeException("KnowledgeBase entry not found with id " + id);
        }
        knowledgeBaseRepository.deleteById(id);
    }
}
