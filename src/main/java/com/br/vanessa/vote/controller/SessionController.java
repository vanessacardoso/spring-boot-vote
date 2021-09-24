package com.br.vanessa.vote.controller;

import com.br.vanessa.vote.controller.request.SessionRequest;
import com.br.vanessa.vote.controller.response.SessionResponse;
import com.br.vanessa.vote.controller.response.SessionResultVotingResponse;
import com.br.vanessa.vote.model.Session;
import com.br.vanessa.vote.service.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public SessionResponse createSession(@RequestBody SessionRequest request) throws Exception {
        Session session = sessionService.create(request);
        return new SessionResponse(session);
    }

    @GetMapping("/vote-result/{id}")
    public SessionResultVotingResponse counterResultVotes(@PathVariable Long id) {
        Session session = sessionService.counterVotes(id);
        return new SessionResultVotingResponse(session);
    }
}
