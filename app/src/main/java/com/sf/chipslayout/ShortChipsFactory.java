package com.sf.chipslayout;

import android.support.v7.widget.RecyclerView;

import com.sf.chipslayout.adapter.ChipsAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ShortChipsFactory implements IItemsFactory<ChipsEntity> {

    @Override
    public List<ChipsEntity> getFewItems() {

        List<ChipsEntity> chipsList = new ArrayList<>();

        chipsList.add(ChipsEntity.newBuilder()
                .drawableResId(R.drawable.batman)
                .name("Batman")
                .build());

        chipsList.add(ChipsEntity.newBuilder()
                .name("V")
                .build());

        chipsList.add(ChipsEntity.newBuilder()
                .drawableResId(R.drawable.girl2)
                .name("Jayne")
                .description("Everyone want to meet Jayne")
                .build());

        chipsList.add(ChipsEntity.newBuilder()
                .drawableResId(R.drawable.girl3)
                .name("Cat")
                .build());

        chipsList.add(ChipsEntity.newBuilder()
                .name("J")
                .build());

        chipsList.add(ChipsEntity.newBuilder()
                .name("A")
                .build());

        chipsList.add(ChipsEntity.newBuilder()
                .drawableResId(R.drawable.batman)
                .name("Second Batman")
                .description("Batman is our friend")
                .build());

        chipsList.add(ChipsEntity.newBuilder()
                .name("C")
                .build());

        chipsList.add(ChipsEntity.newBuilder()
                .drawableResId(R.drawable.karl)
                .name("Karl")
                .build());

        chipsList.add(ChipsEntity.newBuilder()
                .drawableResId(R.drawable.anonymous)
                .name("Very Long Name Anonymous")
                .build());

        return chipsList;
    }

    @Override
    public List<ChipsEntity> getItems() {
        List<ChipsEntity> chipsEntities = getFewItems();

        List<ChipsEntity> secondPortion = getFewItems();
        Collections.reverse(secondPortion);
        chipsEntities.addAll(secondPortion);
        chipsEntities.addAll(getFewItems());
        chipsEntities.addAll(getFewItems());

        for (int i = 0; i < chipsEntities.size(); i++) {
            ChipsEntity chipsEntity = chipsEntities.get(i);
            chipsEntity.setName(chipsEntity.getName() + " " + i);
        }

        return chipsEntities;
    }

    @Override
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> createAdapter(List<ChipsEntity> chipsEntities, OnRemoveListener onRemoveListener) {
        return new ChipsAdapter(chipsEntities, onRemoveListener);
    }
}
