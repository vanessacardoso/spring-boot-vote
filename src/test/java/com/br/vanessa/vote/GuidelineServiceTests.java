package com.br.vanessa.vote;

import com.br.vanessa.vote.model.Guideline;
import com.br.vanessa.vote.repository.GuidelineRepository;
import com.br.vanessa.vote.service.GuidelineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.openMocks;

public class GuidelineServiceTests {

    @Mock
    private GuidelineRepository guidelineRepository;

    private GuidelineService guidelineService;

    @BeforeEach
    public void setup() {
        openMocks(this);
        guidelineService = new GuidelineService(guidelineRepository);
    }

    @Nested
    @DisplayName("Create guideline")
    class saveNewGuideline {
        @Test
        @DisplayName("Then save new request guideline should return the new guideline")
        void shouldSaveGuideline() {
            Guideline guidelineSaved = savedGuideline();
            Guideline newGuideline = requestNewGuideline();

            given(guidelineRepository.save(newGuideline)).willReturn(guidelineSaved);
            Guideline result = guidelineService.create(newGuideline);

            assertEquals(guidelineSaved.getTitle(), result.getTitle());
            assertNotNull(result.getId());
        }
    }

    private Guideline savedGuideline() {
        return new Guideline(1L, "Pauta: Social", "Definição do projeto");
    }

    private Guideline requestNewGuideline() {
        return new Guideline("Pauta: Social", "Definição do projeto");
    }

}
