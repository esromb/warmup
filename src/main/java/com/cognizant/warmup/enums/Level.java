package com.cognizant.warmup.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Level {

	ONE, TWO, THREE;

	Level() {
	}

	@JsonValue
    public int toValue() {
        return ordinal();
    }
}
