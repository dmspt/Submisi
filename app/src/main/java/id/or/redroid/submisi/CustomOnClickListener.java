package id.or.redroid.submisi;

import android.view.View;

class CustomOnClickListener implements View.OnClickListener {

    private int position;
    private OnItemClickCallback onItemClickCallback;

    public CustomOnClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, position);
    }

    public interface OnItemClickCallback {
        void onItemClicked(View view, int position);
    }
}