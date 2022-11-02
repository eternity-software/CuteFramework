package ru.etysoft.cuteframework.methods;

import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.storage.Cache;

public abstract class AuthorizedRequest extends RequestHolder {
    public AuthorizedRequest(String method) throws NotCachedException {
        super(method);
        addHeaders(Pair.make(APIKeys.Headers.BEARER, Cache.getUserAccount().getAccessToken()));
    }
}
