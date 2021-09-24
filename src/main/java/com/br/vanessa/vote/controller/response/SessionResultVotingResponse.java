package com.br.vanessa.vote.controller.response;

import com.br.vanessa.vote.model.Session;

public class SessionResultVotingResponse {

    private Long idSession;
    private Long voteYes;
    private Long voteNo;

    public SessionResultVotingResponse(Session session) {
    }
}
