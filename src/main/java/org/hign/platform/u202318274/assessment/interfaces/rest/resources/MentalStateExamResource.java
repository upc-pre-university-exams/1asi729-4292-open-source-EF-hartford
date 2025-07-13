package org.hign.platform.u202318274.assessment.interfaces.rest.resources;

import java.util.Date;

public record MentalStateExamResource(
        Long Id,
        Long patientId,
        String examinerNationalProviderIdentifier,
        String examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore

) {
}
