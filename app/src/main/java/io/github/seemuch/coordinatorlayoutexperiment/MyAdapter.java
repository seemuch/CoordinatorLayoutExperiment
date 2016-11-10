package io.github.seemuch.coordinatorlayoutexperiment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private List<String> mDataset;

    public MyAdapter(List<String> dataset) {
        mDataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_list_item, parent, false);
            return new VHItem(itemView);
        } else if (viewType == TYPE_HEADER) {
            View headerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.input_methods, parent, false);
            return new VHHeader(headerView);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VHItem) {
            TextView txtView = ((VHItem) holder).mTextView;
            txtView.setText(mDataset.get(position - 1));
        }
    }


    @Override
    public int getItemCount() {
        return mDataset.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    class VHItem extends ViewHolder {
        public TextView mTextView;
        public VHItem(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.user_name_txt_view);
        }
    }

    class VHHeader extends ViewHolder {
        public VHHeader(View itemView) {
            super(itemView);
        }
    }
}
