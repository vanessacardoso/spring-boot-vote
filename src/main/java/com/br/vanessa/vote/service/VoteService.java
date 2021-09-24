package com.br.vanessa.vote.service;

import com.br.vanessa.vote.model.Vote;
import com.br.vanessa.vote.repository.VoteRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote create(Vote vote) {
        return voteRepository.save(vote);
    }
}
