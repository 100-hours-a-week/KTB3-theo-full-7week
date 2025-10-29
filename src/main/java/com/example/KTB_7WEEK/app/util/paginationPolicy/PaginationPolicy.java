package com.example.KTB_7WEEK.app.util.paginationPolicy;

import java.util.Comparator;
import java.util.function.Predicate;

public interface PaginationPolicy<T> {

    int limit();

    Comparator<T> comparator();

    Predicate<T> predicate();

    long offset(int page);
}
