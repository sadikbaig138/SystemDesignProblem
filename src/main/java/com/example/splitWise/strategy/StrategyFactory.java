package com.example.splitWise.strategy;

import com.example.splitWise.enums.SplitType;

public class StrategyFactory {

    private SplitStrategy strategy;

    public static SplitStrategy getInstance(SplitType type){
        return switch(type){
            case SplitType.EQUAL -> new EqualsSplitStrategy();
            case SplitType.EXACT -> new ExactSplitStrategy();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

}
