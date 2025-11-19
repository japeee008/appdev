package com.appdev.altf4.seloteriog5.repository;

import com.appdev.altf4.seloteriog5.entity.KnowledgeBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeBaseRepository extends JpaRepository<KnowledgeBase, Long> {
    
}
