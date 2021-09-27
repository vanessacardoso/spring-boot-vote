package com.br.vanessa.vote.controller;

import com.br.vanessa.vote.controller.request.VoteRequest;
import com.br.vanessa.vote.controller.response.VoteResponse;
import com.br.vanessa.vote.model.Vote;
import com.br.vanessa.vote.service.VoteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/voting")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @ApiOperation(value = "Registra o voto", notes = "Este endpoint computa o voto por sessão")
    @ApiResponses({ @ApiResponse(code = 200, message = "Voto criado com sucesso")})
    @PostMapping
    public VoteResponse userVoting(@Valid @RequestBody VoteRequest request) {
        Vote vote = voteService.create(new Vote(request));
        return new VoteResponse(vote);
    }
}
