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

public class ViewPagerState implements Parcelable {
    public final Parcelable mViewPagerSavedState;
    public final int valueToSave;

    public ViewPagerState(Parcelable viewPagerSavedState, int layoutDirection) {
        mViewPagerSavedState = viewPagerSavedState;
        valueToSave = layoutDirection;
    }

    private ViewPagerState(Parcel in, ClassLoader loader) {
        if (loader == null) {
            loader = getClass().getClassLoader();
        }
        mViewPagerSavedState = in.readParcelable(loader);
        valueToSave = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(mViewPagerSavedState, flags);
        out.writeInt(valueToSave);
    }

    // The `CREATOR` field is used to create the parcelable from a parcel, even though it is never referenced directly.
    public static final Parcelable.ClassLoaderCreator<ViewPagerState> CREATOR
            = new Parcelable.ClassLoaderCreator<ViewPagerState>() {
        @Override
        public ViewPagerState createFromParcel(Parcel source) {
            return createFromParcel(source, null);
        }

        @Override
        public ViewPagerState createFromParcel(Parcel source, ClassLoader loader) {
            return new ViewPagerState(source, loader);
        }

        @Override
        public ViewPagerState[] newArray(int size) {
            return new ViewPagerState[size];
        }
    };
}