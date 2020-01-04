package com.siarhei.jpatransactionaldemo.operation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OUT")
public class OutOperation extends Operation {
}
