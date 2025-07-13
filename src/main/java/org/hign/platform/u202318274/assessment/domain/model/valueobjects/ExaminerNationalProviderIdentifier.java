package org.hign.platform.u202318274.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ExaminerNationalProviderIdentifier(UUID examinerNationalProviderIdentifier) {
    public ExaminerNationalProviderIdentifier {
        if (examinerNationalProviderIdentifier == null) {
            throw new IllegalArgumentException("Examiner National Provider Identifier cannot be null");
        }
        if (examinerNationalProviderIdentifier.toString().isEmpty()) {
            throw new IllegalArgumentException("Examiner National Provider Identifier cannot be empty");
        }
    }

}
