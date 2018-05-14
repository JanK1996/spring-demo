package com.example.demo.model;

import com.example.demo.complex.Complex;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ComplexRequest {

    private final Complex left;

    public Complex getLeft() {
        return left;
    }

    public Complex getRight() {
        return right;
    }

    private final Complex right;

    @JsonCreator
    public ComplexRequest(@JsonProperty("left") Complex left,@JsonProperty("right") Complex right) {
        this.left = left;
        this.right = right;
    }
}
