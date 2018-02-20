package com.sf.chipslayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;
import com.beloo.widget.chipslayoutmanager.SpacingItemDecoration;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA = "data";
    private RecyclerView.Adapter adapter;
    private List<String> positions;
    private List items;
    private RecyclerView recyclerView;

    /**
     * replace here different data sets
     */
    private IItemsFactory itemsFactory = new ShortChipsFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = createAdapter(savedInstanceState);

        ChipsLayoutManager spanLayoutManager = ChipsLayoutManager.newBuilder(getApplicationContext())
                .setOrientation(ChipsLayoutManager.HORIZONTAL)
                .build();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.addItemDecoration(new SpacingItemDecoration(getResources().getDimensionPixelOffset(R.dimen.item_space),
                getResources().getDimensionPixelOffset(R.dimen.item_space)));

        recyclerView.setLayoutManager(spanLayoutManager);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 10);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(1, 10);
        recyclerView.setAdapter(adapter);

    }

    private OnRemoveListener onRemoveListener = new OnRemoveListener() {
        @Override
        public void onItemRemoved(int position) {
            items.remove(position);
            Log.i("activity", "delete at " + position);
            adapter.notifyItemRemoved(position);
        }
    };

    private RecyclerView.Adapter createAdapter(Bundle savedInstanceState) {

        List<String> items;
        if (savedInstanceState == null) {
//            items = itemsFactory.getFewItems();
//            items = itemsFactory.getALotOfItems();
            items = itemsFactory.getItems();
        } else {
            items = savedInstanceState.getStringArrayList(EXTRA);
        }

        adapter = itemsFactory.createAdapter(items, onRemoveListener);
        this.items = items;

        return adapter;

    }
}
