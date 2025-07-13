package org.hign.platform.u202318274.personnel.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record NationalProviderIdentifier(UUID nationalProviderRecordIdentifier) {
    public NationalProviderIdentifier {
        if (nationalProviderRecordIdentifier == null) {
            throw new IllegalArgumentException("National Provider Identifier cannot be null");
        }
        if (nationalProviderRecordIdentifier.toString().isEmpty()) {
            throw new IllegalArgumentException("National Provider Identifier cannot be empty");
        }
    }

    public NationalProviderIdentifier() {
        this(UUID.randomUUID());
    }

    public String getIdentifier() {
        return nationalProviderRecordIdentifier.toString();
    }

}
