package org.hign.platform.u202318274.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ExaminerNationalProviderRecordId(UUID examinerNationalProviderIdentifier) {
    public ExaminerNationalProviderRecordId {
        if (examinerNationalProviderIdentifier == null || examinerNationalProviderIdentifier.toString().isBlank()) {
            throw new IllegalArgumentException("Examiner National Provider Identifier cannot be null");
        }
    }
}
