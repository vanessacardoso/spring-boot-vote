package com.br.vanessa.vote.repository;

import com.br.vanessa.vote.model.Vote;
import com.br.vanessa.vote.model.VoteEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Long countAllByIdSessionAndVote(Long idSession, VoteEnum vote);

    Long countAllByIdSession(Long idSession);
}
