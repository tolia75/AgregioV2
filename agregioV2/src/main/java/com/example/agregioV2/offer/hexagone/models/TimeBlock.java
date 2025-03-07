package com.example.agregioV2.offer.hexagone.models;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class TimeBlock {

    private final LocalTime startTime;
    private final LocalTime endTime;
    private final Price floorPrice;

    public TimeBlock(LocalTime startTime, LocalTime endTime, Price floorPrice) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.floorPrice = floorPrice;
    }

    public static List<TimeBlock> createTimeBlocks(int blocsNumber, Price floorPrice) {
        Duration totalDuration = Duration.ofHours(24);
        Duration blockDuration = totalDuration.dividedBy(blocsNumber);

        return createTimeBlocks(blocsNumber, blockDuration, floorPrice);
    }

    private static List<TimeBlock> createTimeBlocks(int blocsNumber, Duration blockDuration, Price floorPrice) {
        return IntStream.range(0, blocsNumber)
                .mapToObj(blockNumber -> createTimeBlock(blockDuration, floorPrice, blockNumber))
                .toList();
    }

    private static TimeBlock createTimeBlock(Duration blockDuration, Price floorPrice, int blockNumber) {
        LocalTime startTime = LocalTime.MIDNIGHT.plus(blockDuration.multipliedBy(blockNumber));
        LocalTime endTime = startTime.plus(blockDuration);
        return new TimeBlock(startTime, endTime, floorPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeBlock timeBlock = (TimeBlock) o;
        return Objects.equals(startTime, timeBlock.startTime) && Objects.equals(endTime, timeBlock.endTime) && Objects.equals(floorPrice, timeBlock.floorPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime, floorPrice);
    }
}
