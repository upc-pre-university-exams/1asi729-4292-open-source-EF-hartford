package org.hign.platform.u202318274.assessment.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.UUID;

public record MentalStateExamResource(
        Long Id,
        Long patientId,
        UUID examinerNationalProviderIdentifier,
        Date examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore

) {
}
