package com.br.vanessa.vote.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Objects;

@Service
public class ConsultUserInfoService {

    private final ConsultUserInfoClient consultUserInfoClient;

    public ConsultUserInfoService(ConsultUserInfoClient consultUserInfoClient) {
        this.consultUserInfoClient = consultUserInfoClient;
    }

    public void valideCPF(String cpf) {
        try {
            UserToVote user = consultUserInfoClient.consultCpf(cpf);
            if ((Objects.requireNonNull(user).getStatus().equals(UserStatusToVoteEnum.UNABLE_TO_VOTE))) {
                throw new UserNotAbleVoteException();
            }
        } catch (HttpClientErrorException ex) {
            throw new UserCPFInvalidException();
        }
    }
}



