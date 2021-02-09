/**
Copyright (C) 2020 Link Development

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 **/
package com.linkdev.sample.ui.tabs.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.linkdev.sample.data.ViewExampleData


class ViewPagerAdapter(
    private val mContext: Context

) : PagerAdapter() {
    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val viewExampleData = ViewExampleData.values()
        val inflater = LayoutInflater.from(mContext)
        val layout =
            inflater.inflate(viewExampleData[position].layoutId, collection, false) as ViewGroup
        collection.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return ViewExampleData.values().size
    }

    override fun getPageTitle(position: Int): CharSequence {

        return mContext.getString(ViewExampleData.values()[position].title)
    }
}



