package io.github.dft.walmartsdk.model.common;


import lombok.Data;

import java.util.List;

@Data
public class Errors{

    private List<Error> error;
}