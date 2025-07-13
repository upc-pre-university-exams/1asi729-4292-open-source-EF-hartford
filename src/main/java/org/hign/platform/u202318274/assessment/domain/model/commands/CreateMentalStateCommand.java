package org.hign.platform.u202318274.assessment.domain.model.commands;

import java.util.Date;
import java.util.UUID;

public record CreateMentalStateCommand(
        Long patientId,
        Date examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {
    public CreateMentalStateCommand {
        if (patientId == null || patientId <= 0) {
            throw new IllegalArgumentException("Patient ID must not be null or must be a positive number.");
        }
        if (examDate == null) {
            throw new IllegalArgumentException("Exam date must not be null.");
        }
        if (orientationScore == null || orientationScore < 0) {
            throw new IllegalArgumentException("Orientation score must not be null and must be a non-negative number.");
        }
        if (registrationScore == null || registrationScore < 0) {
            throw new IllegalArgumentException("Registration score must not be null and must be a non-negative number.");
        }
        if (attentionAndCalculationScore == null || attentionAndCalculationScore < 0) {
            throw new IllegalArgumentException("Attention and calculation score must not be null and must be a non-negative number.");
        }
        if (recallScore == null || recallScore < 0) {
            throw new IllegalArgumentException("Recall score must not be null and must be a non-negative number.");
        }
        if (languageScore == null || languageScore < 0) {
            throw new IllegalArgumentException("Language score must not be null and must be a non-negative number.");
        }
    }
}
