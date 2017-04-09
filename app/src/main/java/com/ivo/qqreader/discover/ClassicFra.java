package com.ivo.qqreader.discover;

public
class ClassicFra extends InfoFra{

    @Override
    protected int actionTag() {
        return 1;
    }

    @Override
    protected boolean supportLoadMore() {
        return false;
    }

}
