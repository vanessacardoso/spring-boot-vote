package com.br.vanessa.vote.service;

import com.br.vanessa.vote.client.ConsultUserInfoService;
import com.br.vanessa.vote.model.Vote;
import com.br.vanessa.vote.repository.VoteRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final ConsultUserInfoService consultUserInfoService;

    public VoteService(VoteRepository voteRepository, ConsultUserInfoService consultUserInfoService) {
        this.voteRepository = voteRepository;
        this.consultUserInfoService = consultUserInfoService;
    }

    public Vote create(Vote vote) {
        consultUserInfoService.valideCPF(vote.getCpf());
        return voteRepository.save(vote);
    }
}
