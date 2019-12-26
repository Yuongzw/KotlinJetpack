package com.xiangxue.alvin.flowlayout;

import androidx.annotation.NonNull;

/**
 * author : zhiwen.yang
 * date   : 2019/12/26
 * desc   :
 */
public class ParallaxViewTag {
    protected int index;
    protected float xIn;
    protected float xOut;
    protected float yIn;
    protected float yOut;
    protected float alphaIn;
    protected float alphaOut;

    @NonNull
    @Override
    public String toString() {
        return "ParallaxViewTag [index=" + index +", xIn=" + xIn + ",xOut="+ xOut+
                ",yIn="+ yIn+ ",yOut="+ yOut+ ",alphaIn="+ alphaIn+ ",alphaOut="+ alphaOut + "]";
    }
}
