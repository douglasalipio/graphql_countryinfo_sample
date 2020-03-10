package com.douglas.interview.countriesinfo.utils

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder

fun RecyclerView.initGridLayout(
	context: Context,
	groupAdapter: GroupAdapter<GroupieViewHolder>
) {

	val gridLayoutManager = LinearLayoutManager(context)
	this.adapter = groupAdapter
	this.layoutManager = gridLayoutManager
}
