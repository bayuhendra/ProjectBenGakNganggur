package com.bitozen.training.domain.shared;

/**
 *
 * @author leevy.malik
 */
public interface AggregateObject<T> {

    boolean sameIdentityAs(T other);
}
