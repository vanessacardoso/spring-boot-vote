package com.br.vanessa.vote;

import com.br.vanessa.vote.client.ConsultUserInfoService;
import com.br.vanessa.vote.model.Vote;
import com.br.vanessa.vote.model.VoteEnum;
import com.br.vanessa.vote.repository.VoteRepository;
import com.br.vanessa.vote.service.VoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.openMocks;

public class VoteServiceTests {

    @Mock
    private VoteRepository voteRepository;

    private VoteService voteService;

    private ConsultUserInfoService consultUserInfoService;

    @BeforeEach
    public void setup() {
        openMocks(this);
        voteService = new VoteService(voteRepository, consultUserInfoService);
    }

    @Nested
    @DisplayName("Create Vote")
    class saveNewVote {
        @Test
        @DisplayName("Then save new request vote YES should return the new vote equals YES")
        void shouldSaveVoteYES() {
            Vote voteSaved = savedVote();
            Vote newRequestVote = requestNewVote();

            given(voteRepository.save(newRequestVote)).willReturn(voteSaved);
            Vote result = voteService.create(newRequestVote);

            assertEquals(voteSaved.getVote().equals(VoteEnum.SIM), result.getVote().equals(VoteEnum.SIM));
            assertNotNull(result.getId());
        }

        @Test
        @DisplayName("Then save new request vote NO should return the new vote equals NO")
        void shouldSaveVoteNO() {
            Vote voteSaved = savedVote();
            voteSaved.setVote(VoteEnum.NÃO);
            Vote newRequestVote = requestNewVote();
            newRequestVote.setVote(VoteEnum.NÃO);

            given(voteRepository.save(newRequestVote)).willReturn(voteSaved);
            Vote result = voteService.create(newRequestVote);

            assertEquals(voteSaved.getVote().equals(VoteEnum.NÃO), result.getVote().equals(VoteEnum.NÃO));
            assertNotNull(result.getId());
        }
    }

    private Vote requestNewVote() {
        return new Vote(1L, "02097779077", VoteEnum.SIM);
    }

    private Vote savedVote() {
        return new Vote(1L, 1L, "02097779077", VoteEnum.SIM);
    }

}
