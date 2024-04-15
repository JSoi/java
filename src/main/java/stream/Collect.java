package stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@Slf4j
public class Collect<T> {
    // Create a Logger
    @Builder.Default
    List<T> collection = new ArrayList<>();

    public <R> Map<T, R> collect(Collector<T, R, R> collector) {
        Map<T, R> collect = collection.stream().collect(Collectors.groupingBy(a -> a, collector));
        log.info("RESULT = {}", collect);
        return collect;
    }
}
