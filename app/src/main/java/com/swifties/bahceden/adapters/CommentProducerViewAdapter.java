package com.swifties.bahceden.adapters;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.swifties.bahceden.R;

public class CommentProducerViewAdapter extends RecyclerView.Adapter<CommentProducerViewAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comment_producer_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.replyEdit.setVisibility(View.VISIBLE);
                holder.replyButton.setVisibility(View.GONE);
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.pop);
                holder.replyEdit.startAnimation(animation);
                holder.likeCount.setVisibility(View.GONE);
                holder.commentDate.setVisibility(View.GONE);
            }
        });

        holder.replyEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                holder.replyEdit.setVisibility(View.GONE);
                holder.replyButton.setVisibility(View.VISIBLE);
                holder.likeCount.setVisibility(View.VISIBLE);
                holder.commentDate.setVisibility(View.VISIBLE);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 31;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        EditText replyEdit;
        ImageView replyButton;

        TextView likeCount;

        TextView commentDate;
        public ViewHolder(View view) {
            super(view);

            replyEdit = view.findViewById(R.id.commentReplyEditText);
            replyButton = view.findViewById(R.id.commentReplyButton);
            likeCount = view.findViewById(R.id.likeCount);
            commentDate = view.findViewById(R.id.commentDate);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(view.getContext(), "BaS:" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
