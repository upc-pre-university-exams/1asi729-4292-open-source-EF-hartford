package org.hign.platform.u202318274.assessment.interfaces.rest.resources;

import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.UUID;

public record CreateMentalStateExamResource(
        Long patientId,
        UUID examinerNationalProviderId,

        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "examDate must be in yyyy-MM-dd format")
        String examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore


) {
}
