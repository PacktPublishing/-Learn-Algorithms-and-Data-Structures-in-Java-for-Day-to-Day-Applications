package com.tomekl007;

import com.tomekl007.hashtable.CustomHashTable;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class HashTableTest {

    @Test
    public void whenAddElementToCustomHashTableThenShouldRetrieveIt() {
        //given
        CustomHashTable<String, Integer> map = new CustomHashTable<>();

        //when
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);

        //then
        assertThat(map.size()).isEqualTo(3);
        assertThat(map.get("a")).isEqualTo(1);
        assertThat(map.containsKey("a")).isTrue();
        assertThat(map.containsKey("d")).isFalse();
    }

    @Test
    public void addMultipleElementsToTheHashTable() {
        //given
        CustomHashTable<String, Integer> map = new CustomHashTable<>();

        //when
        IntStream.range(0, 10_000).forEach(i ->
                map.put(String.valueOf(i), i)
        );

        //then
        assertThat(map.size()).isEqualTo(10_000);
    }

    @Test
    public void whenUsingObjectWithIncorrectHashCodeThenAllElementsWillLandInTheSameBucket() {
        //given
        CustomHashTable<BrokenHashCode, Integer> map = new CustomHashTable<>();

        //when
        IntStream.range(0, 10_000).forEach(i ->
                map.put(new BrokenHashCode(i), i)
        );

        //then
        assertThat(
                map.getHashCodesDistribution()
                        .stream()
                        .filter(v -> v.equals(10_000))
                        .collect(Collectors.toList())
                        .size()
        ).isEqualTo(1);
        assertThat(map.size()).isEqualTo(10_000);
    }

    @Test
    public void whenUsingObjectWithCorrectHashCodeThenDataShouldBeDistributedEquallyInAllBuckets() {
        //given
        CustomHashTable<ProperHashCode, Integer> map = new CustomHashTable<>();

        //when
        IntStream.range(0, 10_000).forEach(i ->
                map.put(new ProperHashCode(i), i)
        );

        //then
        assertThat(
                map.getHashCodesDistribution()
                        .stream()
                        .filter(v -> v.equals(1_000))
                        .collect(Collectors.toList())
                        .size()
        ).isEqualTo(10);
        assertThat(map.size()).isEqualTo(10_000);
    }


    @Test
    public void whenAddElementToMapThenShouldRetrieveIt() {
        //given
        Map<String, Integer> map = new HashMap<>();

        //when
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);

        //then
        assertThat(map.size()).isEqualTo(3);
        assertThat(map.get("a")).isEqualTo(1);
        assertThat(map.containsKey("a")).isTrue();
    }

    private class BrokenHashCode {
        private final int value;

        public BrokenHashCode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BrokenHashCode that = (BrokenHashCode) o;

            return value == that.value;
        }

        @Override
        public int hashCode() {
            return 1; //broker hash code
        }
    }

    private class ProperHashCode {
        private final int value;

        public ProperHashCode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ProperHashCode that = (ProperHashCode) o;

            return value == that.value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }


}
