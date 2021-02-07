/**
 * Copyright (C) 2020 Link Development
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.linkdev.rtlviewpager.data.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class ViewPagerSavedState extends View.BaseSavedState {


    public ViewPagerSavedState(Parcelable superState) {
        super(superState);
    }

    private ViewPagerSavedState(Parcel in) {
        super(in);

    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
    }

    //required field that makes Parcelables from a Parcel
    public static final Parcelable.Creator<ViewPagerSavedState> CREATOR =
            new Parcelable.Creator<ViewPagerSavedState>() {
                public ViewPagerSavedState createFromParcel(Parcel in) {
                    return new ViewPagerSavedState(in);
                }

                public ViewPagerSavedState[] newArray(int size) {
                    return new ViewPagerSavedState[size];
                }
            };
}