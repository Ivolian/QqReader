package com.ivo.qqreader.discover;

public class LatestFra extends InfoFra{

    @Override
    protected int actionTag() {
        return 0;
    }

    @Override
    protected boolean supportLoadMore() {
        return true;
    }

}
