package com.br.vanessa.vote.service;

import com.br.vanessa.vote.model.Guideline;
import com.br.vanessa.vote.repository.GuidelineRepository;
import org.springframework.stereotype.Service;

@Service
public class GuidelineService {

    private final GuidelineRepository guidelineRepository;

    public GuidelineService(GuidelineRepository guidelineRepository) {
        this.guidelineRepository = guidelineRepository;
    }

    public Guideline create(Guideline request) {
        return guidelineRepository.save(request);
    }

}
