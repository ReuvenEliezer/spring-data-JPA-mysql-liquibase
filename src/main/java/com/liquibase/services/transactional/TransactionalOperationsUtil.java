package com.liquibase.services.transactional;

public interface TransactionalOperationsUtil {

    <T> T invokeTransactional(TransactionalOperationsUtilImpl.TransactionalInvokeAction<T> action);

}
