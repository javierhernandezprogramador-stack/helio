package com.hernandezsanchez.dev.helio.common.application.mediator;

public interface RequestHandler<T extends Request<R>, R> {

    R handle(T request);

    Class<T> getRequestType();
}
