package org.hign.platform.u202318274.personnel.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record NationalProviderId(UUID nationalProviderRecordIdentifier) {
    public NationalProviderId {
        if (nationalProviderRecordIdentifier == null || nationalProviderRecordIdentifier.toString().isBlank()) {
            throw new IllegalArgumentException("National Provider Record Identifier cannot be null");
        }
    }


}
