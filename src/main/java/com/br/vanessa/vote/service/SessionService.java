package com.br.vanessa.vote.service;

import com.br.vanessa.vote.controller.request.SessionRequest;
import com.br.vanessa.vote.controller.response.SessionResultVotingResponse;
import com.br.vanessa.vote.exception.GuidelineNotFound;
import com.br.vanessa.vote.model.Guideline;
import com.br.vanessa.vote.model.Session;
import com.br.vanessa.vote.model.VoteEnum;
import com.br.vanessa.vote.repository.GuidelineRepository;
import com.br.vanessa.vote.repository.SessionRepository;
import com.br.vanessa.vote.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final GuidelineRepository guidelineRepository;
    private final VoteRepository voteRepository;
    public static final int TIME_DEFAULT = 1;

    public SessionService(SessionRepository sessionRepository, GuidelineRepository guidelineRepository, VoteRepository voteRepository) {
        this.sessionRepository = sessionRepository;
        this.guidelineRepository = guidelineRepository;
        this.voteRepository = voteRepository;
    }

    public Session create(SessionRequest request)  {
        LocalDateTime startDateNow = LocalDateTime.now();
        if (request.getTimeDuration() == null) {
            return defaultTimeSession(request, startDateNow);
        } else {
            return customTimeSession(request, startDateNow);
        }
    }

    public Session defaultTimeSession(SessionRequest request, LocalDateTime startDateNow)  {
        Guideline guideline = existsGuidelineById(request.getIdGuideline());
        Session sessionSet = Session.builder()
                .idGuideline(guideline)
                .startSession(startDateNow)
                .endSession(startDateNow.plusMinutes(TIME_DEFAULT))
                .build();
        return sessionRepository.save(sessionSet);
    }

    public Session customTimeSession(SessionRequest request, LocalDateTime startDateNow) {
        Guideline guideline = existsGuidelineById(request.getIdGuideline());
        Session sessionSet = Session.builder()
                .idGuideline(guideline)
                .startSession(startDateNow)
                .endSession(startDateNow.plusMinutes(request.getTimeDuration()))
                .build();
        return sessionRepository.save(sessionSet);
    }

    public Guideline existsGuidelineById(Long idGuideline)  {
        Optional<Guideline> guideline = guidelineRepository.findById(idGuideline);
        return guideline.orElseThrow(GuidelineNotFound::new);
    }

    public SessionResultVotingResponse counterVotes(Long idSession) {
        Long voteYes = voteRepository.countAllByIdSessionAndVote(idSession, VoteEnum.SIM);
        Long voteNo = voteRepository.countAllByIdSessionAndVote(idSession, VoteEnum.NÃO);
        Long totalVotes = voteRepository.countAllByIdSession(idSession);
        return SessionResultVotingResponse.builder()
                .idSession(idSession)
                .voteYes(voteYes)
                .voteNo(voteNo)
                .totalVotes(totalVotes)
                .build();
    }
}
