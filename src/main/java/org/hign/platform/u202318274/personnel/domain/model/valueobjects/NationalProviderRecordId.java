package org.hign.platform.u202318274.personnel.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record NationalProviderRecordId(UUID nationalProviderRecordIdentifier) {
    public NationalProviderRecordId {
        if (nationalProviderRecordIdentifier == null || nationalProviderRecordIdentifier.toString().isBlank()) {
            throw new IllegalArgumentException("National Provider Record Identifier cannot be null");
        }
    }


}
