package com.sf.chipslayout;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by mesutgenc on 20.02.2018.
 */

public interface IItemsFactory<Item> {

    List<Item> getFewItems();

    List<Item> getItems();

    RecyclerView.Adapter<? extends RecyclerView.ViewHolder> createAdapter(List<Item> items, OnRemoveListener onRemoveListener);

}
