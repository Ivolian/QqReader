package com.ivo.qqreader.discover;

import com.ivo.qqreader.discover.info.InfoFra;

public class ClassicFra extends InfoFra {

    @Override
    protected int actionTag() {
        return 1;
    }

    @Override
    protected boolean supportLoadMore() {
        return false;
    }

}
