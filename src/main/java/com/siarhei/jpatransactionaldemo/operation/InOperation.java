package com.siarhei.jpatransactionaldemo.operation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IN")
public class InOperation extends Operation {
}
