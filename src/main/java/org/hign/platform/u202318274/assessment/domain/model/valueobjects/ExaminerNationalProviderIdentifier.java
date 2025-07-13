package org.hign.platform.u202318274.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ExaminerNationalProviderIdentifier(UUID examinerNationalProviderIdentifier) {
    public ExaminerNationalProviderIdentifier {
        if (examinerNationalProviderIdentifier == null) {
            throw new IllegalArgumentException("National Provider Identifier cannot be null");
        }
        if (examinerNationalProviderIdentifier.toString().isEmpty()) {
            throw new IllegalArgumentException("National Provider Identifier cannot be empty");
        }
    }

    public ExaminerNationalProviderIdentifier() {
        this(UUID.randomUUID());
    }

    public String getIdentifier() {
        return examinerNationalProviderIdentifier.toString();
    }

    public ExaminerNationalProviderIdentifier(String value) {
        this(UUID.fromString(value));
    }

    public UUID value() {
        return examinerNationalProviderIdentifier;
    }

}
