package com.br.vanessa.vote.controller;

import com.br.vanessa.vote.controller.request.GuidelineRequest;
import com.br.vanessa.vote.controller.response.GuidelineResponse;
import com.br.vanessa.vote.model.Guideline;
import com.br.vanessa.vote.service.GuidelineService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/guideline")
public class GuidelineController {

    private final GuidelineService guidelineService;

    public GuidelineController(GuidelineService guidelineService) {
        this.guidelineService = guidelineService;
    }

    @ApiOperation(value = "Cria uma pauta", notes = "Este endpoint cria uma pauta")
    @ApiResponses({ @ApiResponse(code = 200, message = "Pauta criada com sucesso")})
    @PostMapping
    public GuidelineResponse createGuideline(@Valid @RequestBody GuidelineRequest request) {
        Guideline guideline = guidelineService.create(new Guideline(request));
        return new GuidelineResponse(guideline);
    }
}
