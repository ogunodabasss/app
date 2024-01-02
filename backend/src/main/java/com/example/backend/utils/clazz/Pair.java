package com.example.backend.utils.clazz;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
public class Pair<FIRS, SECOND> {
    @NotNull
    private final FIRS first;
    @NotNull
    private final SECOND second;

    private Pair(@NotNull FIRS first, @NotNull SECOND second) {
        this.first = first;
        this.second = second;
    }

    public static <FIRS, SECOND> @NotNull Pair<FIRS, SECOND> of(FIRS first, SECOND second) {
        return new Pair<>(first, second);
    }

    public static <S, T> @NotNull Collector<Pair<S, T>, ?, Map<S, T>> toMap() {
        return Collectors.toMap(Pair::getFirst, Pair::getSecond);
    }

    @Override
    public String toString() {
        return this.first + "->" + this.second;
    }
}