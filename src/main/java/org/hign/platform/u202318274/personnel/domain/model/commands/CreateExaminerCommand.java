package org.hign.platform.u202318274.personnel.domain.model.commands;

import java.util.UUID;

public record CreateExaminerCommand(
        String firstName,
        String lastName,
        UUID nationalProviderIdentifier
) {
}
