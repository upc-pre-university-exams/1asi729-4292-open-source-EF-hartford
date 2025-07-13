package org.hign.platform.u202318274.personnel.interfaces.rest.resources;

import java.util.UUID;

public record ExaminerResource(
        Long id,
        String firstName,
        String lastName,
        UUID nationalProviderId
) {
}
