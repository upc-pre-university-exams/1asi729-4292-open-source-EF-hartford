package org.hign.platform.u202318274.personnel.domain.model.queries;

import org.hign.platform.u202318274.personnel.domain.model.valueobjects.NationalProviderIdentifier;

import java.util.UUID;

public record GetExaminerByNationalProviderIdQuery(NationalProviderIdentifier nationalProviderId) {
}
