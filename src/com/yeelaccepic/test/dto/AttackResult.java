package com.yeelaccepic.test.dto;

public enum AttackResult {
    MISS("miss"),
    HIT("hit"),
    SINK("sink");

    private String result;

    AttackResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
