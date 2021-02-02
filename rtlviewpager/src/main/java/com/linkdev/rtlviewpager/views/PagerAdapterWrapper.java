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

package com.linkdev.rtlviewpager.views;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

/**
 * PagerAdapter decorator.
 */
class PagerAdapterWrapper extends PagerAdapter {

    @NonNull
    private final PagerAdapter adapter;

    protected PagerAdapterWrapper(@NonNull PagerAdapter adapter) {
        this.adapter = adapter;
    }

    @NonNull
    public PagerAdapter getInnerAdapter() {
        return adapter;
    }

    @Override
    public int getCount() {
        return adapter.getCount();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return adapter.isViewFromObject(view, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return adapter.getPageTitle(position);
    }

    @Override
    public float getPageWidth(int position) {
        return adapter.getPageWidth(position);
    }

    @Override
    public int getItemPosition(@NotNull Object object) {
        return adapter.getItemPosition(object);
    }

    @NotNull
    @Override
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        return adapter.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        adapter.destroyItem(container, position, object);
    }

    @Override
    public void setPrimaryItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        adapter.setPrimaryItem(container, position, object);
    }

    @Override
    public void notifyDataSetChanged() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void registerDataSetObserver(@NotNull DataSetObserver observer) {
        adapter.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(@NotNull DataSetObserver observer) {
        adapter.unregisterDataSetObserver(observer);
    }

    @Override
    public Parcelable saveState() {
        return adapter.saveState();
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        adapter.restoreState(state, loader);
    }

    @Override
    public void startUpdate(@NotNull ViewGroup container) {
        adapter.startUpdate(container);
    }

    @Override
    public void finishUpdate(@NotNull ViewGroup container) {
        adapter.finishUpdate(container);
    }
}