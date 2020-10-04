package com.siarhei.jpaefficiencyexperiments.bankaccount;

import com.siarhei.jpaefficiencyexperiments.crudbase.entity.BaseJournalEntity;
import com.siarhei.jpaefficiencyexperiments.operation.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_account")
@NamedEntityGraph(
        name = "BankAccount.operations",
        attributeNodes = @NamedAttributeNode("operations")
)
public class BankAccount extends BaseJournalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "balance")
    private Long balance;

    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY)
    private List<Operation> operations;

}
