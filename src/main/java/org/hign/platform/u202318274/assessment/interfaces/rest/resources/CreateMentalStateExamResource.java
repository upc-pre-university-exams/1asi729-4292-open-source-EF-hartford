package org.hign.platform.u202318274.assessment.interfaces.rest.resources;

import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.UUID;

public record CreateMentalStateExamResource(
        Long patientId,
        UUID examinerNationalProviderId,
        String examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore


) {
}
