package com.siarhei.jpatransactionaldemo.crudbase.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class BaseFilter {

    private List<Long> id;

}
