package repository;

import java.util.List;
import java.util.function.Predicate;

public interface Repository<T> {
    boolean add(T value);
    boolean remove(Predicate<T>... predicates);
    boolean update(T value, Predicate<T>... predicates);
    List<T> find(Predicate<T>... predicates);
    T first(Predicate<T>... predicates);
}
