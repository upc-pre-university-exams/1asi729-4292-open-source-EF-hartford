package org.hign.platform.u202318274.personnel.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hign.platform.u202318274.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202318274.personnel.domain.model.valueobjects.NationalProviderRecordId;
import org.hign.platform.u202318274.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Setter
@Entity
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String firstName;

    @Column
    @NotBlank
    private String lastName;

    @Embedded
    @NotNull
    private NationalProviderRecordId nationalProviderIdentifier;

    public Examiner() {
    }

    public Examiner(CreateExaminerCommand command) {
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.nationalProviderIdentifier = new NationalProviderRecordId(command.nationalProviderIdentifier());
    }

}
