package org.hign.platform.u202318274.personnel.domain.model.queries;

import java.util.UUID;

public record GetExaminerByNationalProviderIdentifierQuery(UUID nationalProviderIdentifier) {
    public GetExaminerByNationalProviderIdentifierQuery() {
        this(null);
    }
}
