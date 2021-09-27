package com.br.vanessa.vote;

import com.br.vanessa.vote.controller.request.SessionRequest;
import com.br.vanessa.vote.controller.response.SessionResultVotingResponse;
import com.br.vanessa.vote.exception.GuidelineNotFound;
import com.br.vanessa.vote.model.Guideline;
import com.br.vanessa.vote.model.Session;
import com.br.vanessa.vote.model.VoteEnum;
import com.br.vanessa.vote.repository.GuidelineRepository;
import com.br.vanessa.vote.repository.SessionRepository;
import com.br.vanessa.vote.repository.VoteRepository;
import com.br.vanessa.vote.service.SessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.openMocks;

public class SessionServiceTests {

    @Mock
    private SessionRepository sessionRepository;
    @Mock
    private GuidelineRepository guidelineRepository;
    @Mock
    private VoteRepository voteRepository;
    @Mock
    private SessionService sessionService;

    @BeforeEach
    public void setup() {
        openMocks(this);
        sessionService = new SessionService(sessionRepository, guidelineRepository, voteRepository);
    }

    @Nested
    @DisplayName("Exists Guideline")
    class consultExistsGuideline {
        @Test
        @DisplayName("Return guideline correct by id")
        void returnGuidelineById() {
            Long idGuideline = 1L;
            Guideline optionalGuideline = guideline();
            given(guidelineRepository.findById(idGuideline)).willReturn(Optional.of(optionalGuideline));

            Guideline result = sessionService.existsGuidelineById(idGuideline);

            assertThat(result.getTitle()).isEqualTo(optionalGuideline.getTitle());
        }

        @Test
        @DisplayName("should return guideline not exists")
        void returnGuidelineIncorrect() {
            Long idGuideline = 1L;

            GuidelineNotFound exceptionWithIdGuidelineNotFound = assertThrows(GuidelineNotFound.class, () -> {
                sessionService.existsGuidelineById(idGuideline);
            });

            String expected = "Não foi encontrada a pauta com o id informado";
            assertEquals(expected, exceptionWithIdGuidelineNotFound.getMessage());
        }
    }

    @Nested
    @DisplayName("Create Session")
    class createSession {

        @Test
        @DisplayName("Return session saved when time is null")
        void returnSessionWithTimeDefault() {
            Long idGuideline = 1L;
            LocalDateTime startDateNow = LocalDateTime.now();
            SessionRequest request = sessionRequestNull();

            given(guidelineRepository.findById(idGuideline)).willReturn(Optional.of(guideline()));
            given(sessionRepository.save(newSessionDefault())).willReturn(newSessionDefault());
            given(sessionService.defaultTimeSession(request, startDateNow)).willReturn(saveSession());
            Session result = sessionService.defaultTimeSession(request, startDateNow);

            assertEquals(result.getId(), saveSession().getId());
        }

        @Test
        @DisplayName("Return session saved when time is NOT null")
        void returnSessionWithTimeCustom() {
            Long idGuideline = 1L;
            LocalDateTime startDateNow = LocalDateTime.now();
            SessionRequest request = sessionRequestWithtime();
            Session sessionWithTimeCustom = newSessionCustom();
            sessionWithTimeCustom.setEndSession(startDateNow.plusMinutes(sessionRequestWithtime().getTimeDuration()));

            given(guidelineRepository.findById(idGuideline)).willReturn(Optional.of(guideline()));
            given(sessionRepository.save(newSessionCustom())).willReturn(newSessionCustom());
            given(sessionService.customTimeSession(request, startDateNow)).willReturn(saveSessionWithTimeCustom());
            Session result = sessionService.customTimeSession(request, startDateNow);

            assertEquals(result.getId(), saveSession().getId());
        }
    }

    @Nested
    @DisplayName("Result votes Session")
    class ResultVotingSession {
        @Test
        @DisplayName("Return votes session")
        void returnTotalSessionVotes() {
            Long idSession = 1L;
            Long voteYes = 4L;
            Long voteNo = 5L;
            Long total = 9L;
            SessionResultVotingResponse expected = results();
            given(voteRepository.countAllByIdSessionAndVote(idSession, VoteEnum.SIM)).willReturn(voteYes);
            given(voteRepository.countAllByIdSessionAndVote(idSession, VoteEnum.NÃO)).willReturn(voteNo);
            given(voteRepository.countAllByIdSession(idSession)).willReturn(total);

            SessionResultVotingResponse result = sessionService.counterVotes(idSession);

            assertEquals(expected, result);
        }
    }

    private Guideline guideline() {
        return new Guideline(1L, "Pauta: Social", "Definição do projeto");
    }

    private SessionRequest sessionRequestNull() {
        return new SessionRequest(1L, null);
    }

    private SessionRequest sessionRequestWithtime() {
        return new SessionRequest(1L, 1);
    }

    private Session saveSession() {
        LocalDateTime startDateNow = LocalDateTime.now();
        LocalDateTime end = startDateNow.plusMinutes(1);
        return new Session(1L, guideline(), startDateNow, end);
    }

    private Session saveSessionWithTimeCustom() {
        LocalDateTime startDateNow = LocalDateTime.now();
        LocalDateTime end = startDateNow.plusMinutes(1);
        return new Session(1L, guideline(), startDateNow, end);
    }

    private Session newSessionDefault() {
        LocalDateTime startDateNow = LocalDateTime.now();
        return Session.builder()
                .idGuideline(guideline())
                .startSession(startDateNow)
                .endSession(startDateNow.plusMinutes(1))
                .build();
    }

    private Session newSessionCustom() {
        LocalDateTime startDateNow = LocalDateTime.now();
        return Session.builder()
                .idGuideline(guideline())
                .startSession(startDateNow)
                .endSession(startDateNow.plusMinutes(sessionRequestWithtime().getTimeDuration()))
                .build();
    }

    private SessionResultVotingResponse results() {
        return SessionResultVotingResponse.builder()
                .idSession(1L)
                .voteYes(4L)
                .voteNo(5L)
                .totalVotes(9L)
                .build();
    }
}
