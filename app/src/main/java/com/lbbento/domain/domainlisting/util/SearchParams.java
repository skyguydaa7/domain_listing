package com.lbbento.domain.domainlisting.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lbbento on 3/08/2016.
 */

public final class SearchParams  {

    private String mode;
    private String suburb;
    private String pCodes;
    private String state;

    public SearchParams(@NonNull String pState, @Nullable String pMode, @Nullable String pSuburb, @Nullable String pCodes)  {
        this.mode = pMode;
        this.suburb = pSuburb;
        this.pCodes = pCodes;
        this.state = pState;
    }

    public Map<String,String> toParams() {
        Map<String,String> toReturn = new LinkedHashMap<>();
        if (!(mode==null&&mode.isEmpty()))  toReturn.put("mode", mode);
        if (!(suburb==null&&suburb.isEmpty()))  toReturn.put("sub", suburb);
        if (!(pCodes==null&&pCodes.isEmpty()))  toReturn.put("pCodes", pCodes);
        if (!(state==null&&state.isEmpty()))  toReturn.put("state", state);
        return toReturn;
    }
}
