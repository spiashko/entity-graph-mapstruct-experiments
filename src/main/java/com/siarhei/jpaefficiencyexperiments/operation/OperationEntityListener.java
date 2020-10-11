package com.siarhei.jpaefficiencyexperiments.operation;

import com.siarhei.jpaefficiencyexperiments.operation.event.OperationPreparedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationEventPublisher;

import javax.persistence.PrePersist;

@Configurable
public class OperationEntityListener {

    @Autowired
    private ApplicationEventPublisher publisher;

    @PrePersist
    public void publishOperationPreparedEvent(Operation target) {
        publisher.publishEvent(new OperationPreparedEvent(target));
    }
}
