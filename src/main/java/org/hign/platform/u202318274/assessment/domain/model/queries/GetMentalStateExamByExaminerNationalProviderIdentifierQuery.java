package org.hign.platform.u202318274.assessment.domain.model.queries;

import org.hign.platform.u202318274.assessment.domain.model.valueobjects.ExaminerNationalProviderIdentifier;

import java.util.UUID;

public record GetMentalStateExamByExaminerNationalProviderIdentifierQuery(ExaminerNationalProviderIdentifier examinerNationalProviderIdentifier) {
    public GetMentalStateExamByExaminerNationalProviderIdentifierQuery {
        if (examinerNationalProviderIdentifier == null) {
            throw new IllegalArgumentException("Profile ID must not be null or must be a positive number.");
        }
    }

}