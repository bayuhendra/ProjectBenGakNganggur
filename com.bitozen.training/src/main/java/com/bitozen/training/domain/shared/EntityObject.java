package com.bitozen.training.domain.shared;

/**
 * An entity, as explained in the DDD model
 *  
 */
public interface EntityObject<T> {

  boolean sameIdentityAs(T other);

}
