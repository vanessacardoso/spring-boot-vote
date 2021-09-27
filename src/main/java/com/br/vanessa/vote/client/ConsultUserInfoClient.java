package com.br.vanessa.vote.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://user-info.herokuapp.com", name = "user-cpf-feign-client")
public interface ConsultUserInfoClient {

    @GetMapping("/users/{cpf}")
    UserToVote consultCpf(@PathVariable("cpf") String cpf);
}
