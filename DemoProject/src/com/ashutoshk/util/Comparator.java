package com.ashutoshk.util;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

	int compare(T o1, T o2);
	
	static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
		Objects.requireNonNull(keyExtractor);
		
		return (o1, o2) -> {
			U u1 = keyExtractor.apply(o1);
			U u2 = keyExtractor.apply(o2);
			if (u1 == null && u2 == null) {
				return 0;
			} else if (u1 == null) {
				return 1;
			} else if (u2 == null) {
				return -1;
			} else {
				return u1.compareTo(u2);
			}
			//return u1.compareTo(u2);
		};
	}
	
	default <U extends Comparable<? super U>> Comparator<T> thenComparing(Function<T, U> keyExtractor) {
		Objects.requireNonNull(keyExtractor);
		
		return (o1, o2) -> {
			int result = this.compare(o1, o2);
			if (result == 0) {
				 Comparator<T> other = comparing(keyExtractor);
				 return other.compare(o1, o2);
			} else {
				return result;
			}
		};
	}
	
	default <U extends Comparable<? super U>> Comparator<T> nullsLast() {
		return (o1, o2) -> {
			if (o1 == null && o2 == null) {
				return 0;
			} else if (o1 == null) {
				return 1;
			} else if (o2 == null) {
				return -1;
			} else {
				return this.compare(o1, o2);
			}
		};
	}
	
}
