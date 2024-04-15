package stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

import static org.assertj.core.api.Assertions.assertThat;

class CollectTest {
    @Test
    @DisplayName("TEST - Map")
    void testCollectMap() {
        List<Integer> numbers = List.of(1, 2, 2, 2, 4);
        Collect<Integer> integerCollect = new Collect<>(numbers);
        Collector<Integer, ArrayList<Integer>, ArrayList<Integer>> collector = Collector.of(
                ArrayList::new,  // Supplier: create a new ArrayList
                ArrayList::add, // Accumulator: square and add to list
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                }, // Combiner: combine lists from parallel streams
                ArrayList::new    // Finisher: transform the list to its final form (add all elements to a new list)
        );
        Map<Integer, ArrayList<Integer>> result = integerCollect.collect(collector);
        assertThat(result.keySet()).containsExactlyElementsOf(List.of(1, 2, 4));
        assertThat(result.get(2)).containsExactlyElementsOf(List.of(2, 2, 2));
    }
}