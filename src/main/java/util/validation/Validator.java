package util.validation;

public interface Validator<T> {
    boolean check(T value);
    T correct(T value);
}
