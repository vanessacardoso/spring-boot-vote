package com.br.vanessa.vote.repository;

import com.br.vanessa.vote.model.Guideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuidelineRepository extends JpaRepository<Guideline, Long> {
}
