package com.ivo.qqreader.discover;

import com.ivo.qqreader.discover.info.InfoFra;

public class LatestFra extends InfoFra {

    @Override
    protected int actionTag() {
        return 0;
    }

    @Override
    protected boolean supportLoadMore() {
        return true;
    }

}
