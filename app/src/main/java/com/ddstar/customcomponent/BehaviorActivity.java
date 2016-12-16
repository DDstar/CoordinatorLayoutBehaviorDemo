package com.ddstar.customcomponent;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class BehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);
        RecyclerView rcyView = (RecyclerView) findViewById(R.id.rcyview);
        rcyView.setLayoutManager(new LinearLayoutManager(this));
        rcyView.setAdapter(new RcyAdapter());
    }

    class VH extends RecyclerView.ViewHolder {

        public VH(View itemView) {
            super(itemView);
        }
    }

    class RcyAdapter extends RecyclerView.Adapter<VH> {

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == 0) {
                return new VH(getLayoutInflater().inflate(R.layout.rcy_item_header, null));
            } else {
                return new VH(getLayoutInflater().inflate(R.layout.rcy_item, null));
            }
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {

        }

        @Override
        public int getItemViewType(int position) {
            return position == 0 ? 0 : 1;
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }

}
