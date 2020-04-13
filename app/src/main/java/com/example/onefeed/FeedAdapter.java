package com.example.onefeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private Context cntxt;
    private List<Post> postList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView desc, info;
        public ImageView image;

        public ViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.image);
            desc = (TextView) view.findViewById(R.id.desc);
            info = (TextView) view.findViewById(R.id.info);
        }
    }

    public FeedAdapter(Context cntxt, List<Post> postList) {
        this.cntxt = cntxt;
        this.postList = postList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_feed, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.desc.setText(post.getAccount() + " • " + post.getDesc());
        holder.info.setText("\u2764 " + post.getNumLikes() + " • " + post.getNumComments() + " Comments");
        // use glide to get the image
        Glide.with(cntxt).load(post.getImageURL()).into(holder.image);

        // TO-DO: add an onClickListner here to move to another page
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}


