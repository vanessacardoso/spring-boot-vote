package com.br.vanessa.vote.controller;

import com.br.vanessa.vote.controller.request.VoteRequest;
import com.br.vanessa.vote.controller.response.VoteResponse;
import com.br.vanessa.vote.model.Vote;
import com.br.vanessa.vote.service.VoteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voting")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public VoteResponse userVoting(@RequestBody VoteRequest request) {
        Vote vote = voteService.create(new Vote(request));
        return new VoteResponse(vote);
    }
}
