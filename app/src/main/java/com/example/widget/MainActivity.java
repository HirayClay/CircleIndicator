package com.example.widget;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.widget.adapter.CardAdapter;
import com.example.widget.layoutmanager.CardManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private static List<String> datas = new ArrayList<>();
    private CardAdapter adapter;

    static void fill() {
        datas.add("AlicePurple");
        datas.add("Bob");
        datas.add("Stephan");
        datas.add("Fury");
        datas.add("Weiry");
        datas.add("PingTong");
        datas.add("RoserMan");
        datas.add("BreakingBad");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fill();
        recyclerView = (RecyclerView) findViewById(R.id.cardRecyclerView);
        recyclerView.setLayoutManager(new CardManager(4));
        adapter = new CardAdapter(datas);
        recyclerView.setAdapter(adapter);

        int allDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP;
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, allDirs) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                datas.remove(viewHolder.getLayoutPosition());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                ViewCompat.setTranslationX(viewHolder.itemView, dX);
                ViewCompat.setTranslationY(viewHolder.itemView, dY);
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @OnClick(R.id.recyclerViewActivityEntry)
    public void onClick() {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
}
