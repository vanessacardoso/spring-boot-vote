package com.br.vanessa.vote.controller;

import com.br.vanessa.vote.controller.request.GuidelineRequest;
import com.br.vanessa.vote.controller.response.GuidelineResponse;
import com.br.vanessa.vote.model.Guideline;
import com.br.vanessa.vote.service.GuidelineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guideline")
public class GuidelineController {

    private final GuidelineService guidelineService;

    public GuidelineController(GuidelineService guidelineService) {
        this.guidelineService = guidelineService;
    }

    @PostMapping
    public GuidelineResponse createGuideline(@RequestBody GuidelineRequest request) {
        Guideline guideline = guidelineService.create(new Guideline(request));
        return new GuidelineResponse(guideline);
    }
}
