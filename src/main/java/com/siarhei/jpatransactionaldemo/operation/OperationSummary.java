package com.siarhei.jpatransactionaldemo.operation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "operation")
@NamedEntityGraph(
        name = "Operation.viewb",
        attributeNodes = {
                @NamedAttributeNode("bankAccount"),
        }
)
@Immutable
public class OperationSummary extends BaseOperationEntity {

}
