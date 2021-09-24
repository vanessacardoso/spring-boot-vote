package com.br.vanessa.vote.service;

import com.br.vanessa.vote.controller.request.SessionRequest;
import com.br.vanessa.vote.model.Guideline;
import com.br.vanessa.vote.model.Session;
import com.br.vanessa.vote.repository.GuidelineRepository;
import com.br.vanessa.vote.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final GuidelineRepository guidelineRepository;
    public static final int TIME_DEFAULT = 1;

    public SessionService(SessionRepository sessionRepository, GuidelineRepository guidelineRepository) {
        this.sessionRepository = sessionRepository;
        this.guidelineRepository = guidelineRepository;
    }

    public Session create(SessionRequest request) throws Exception {
        var startDateNow = LocalDateTime.now();
        if (request.getTimeDuration() == null) {
            return defaultTimeSession(request, startDateNow);
        } else {
            return customTimeSession(request, startDateNow);
        }
    }

    private Session defaultTimeSession(SessionRequest request, LocalDateTime startDateNow) throws Exception {
        Guideline guideline = existsGuidelineById(request.getIdGuideline());
        Session sessionSet = Session.builder()
                .idGuideline(guideline)
                .startSession(startDateNow)
                .endSession(startDateNow.plusMinutes(TIME_DEFAULT))
                .build();
        return sessionRepository.save(sessionSet);
    }

    private Session customTimeSession(SessionRequest request, LocalDateTime startDateNow) throws Exception {
        Guideline guideline = existsGuidelineById(request.getIdGuideline());
        Session sessionSet = Session.builder()
                .idGuideline(guideline)
                .startSession(startDateNow)
                .endSession(startDateNow.plusMinutes(request.getTimeDuration()))
                .build();
        return sessionRepository.save(sessionSet);
    }

    private Guideline existsGuidelineById(Long idGuideline) throws Exception {
        Optional<Guideline> guideline = guidelineRepository.findById(idGuideline);
        if (guideline.isEmpty()) {
            throw new Exception();
        }
        return guideline.get();
    }

    public Session counterVotes(Long id) {
        return null;
    }
}
