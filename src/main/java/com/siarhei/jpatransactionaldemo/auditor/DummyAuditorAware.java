package com.siarhei.jpatransactionaldemo.auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class DummyAuditorAware implements AuditorAware<Long> {

    public Optional<Long> getCurrentAuditor() {
        return Optional.of(31L);
    }
}