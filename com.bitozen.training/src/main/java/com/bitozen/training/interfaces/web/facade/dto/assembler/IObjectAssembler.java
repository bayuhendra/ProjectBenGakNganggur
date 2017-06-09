package com.bitozen.training.interfaces.web.facade.dto.assembler;

/**
 *
 * @author merlin
 */
public interface IObjectAssembler<X,Y> {
    Y toDTO(X domainObject);
    X toDomain(Y dtoObject);
}
