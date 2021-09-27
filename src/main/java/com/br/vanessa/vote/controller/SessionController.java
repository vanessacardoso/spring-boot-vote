package com.br.vanessa.vote.controller;

import com.br.vanessa.vote.controller.request.SessionRequest;
import com.br.vanessa.vote.controller.response.SessionResponse;
import com.br.vanessa.vote.controller.response.SessionResultVotingResponse;
import com.br.vanessa.vote.model.Session;
import com.br.vanessa.vote.service.SessionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Cria uma sessão", notes = "Este endpoint cria uma nova sessão")
    @ApiResponses({ @ApiResponse(code = 200, message = "Sessão criada com sucesso")})
    @PostMapping
    public SessionResponse createSession(@RequestBody SessionRequest request) {
        Session session = sessionService.create(request);
        return new SessionResponse(session);
    }

    @ApiOperation(value = "Retorna os resultado dos votos da sessão", notes = "Este endpoint retorna os votos computados da sessão")
    @ApiResponses({ @ApiResponse(code = 200, message = "Resultado final da sessão")})
    @GetMapping("/vote-result/{sessionId}")
    public SessionResultVotingResponse counterResultVotes(@PathVariable Long sessionId) {
        return sessionService.counterVotes(sessionId);
    }
}
