package com.swifties.bahceden.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.swifties.bahceden.R;
import com.swifties.bahceden.databinding.LayoutCommentCustomerViewBinding;
import com.swifties.bahceden.models.Comment;

import java.util.List;

public class CommentCustomerViewAdapter extends RecyclerView.Adapter<CommentCustomerViewAdapter.ViewHolder> {
    List<Comment> comments;
    Context context;
    LayoutInflater inflater;

    public CommentCustomerViewAdapter(List<Comment> comments, Context context, LayoutInflater inflater) {
        this.comments = comments;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutCommentCustomerViewBinding binding = LayoutCommentCustomerViewBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentCustomerViewAdapter.ViewHolder holder, int position) {
        Comment comment = comments.get(position);
        Picasso.get()
                .load(comment.getAuthor().getProfileImageURL())
                .into(holder.binding.commentImage);
        holder.binding.commentName.setText(comment.getAuthor().getName());
        holder.binding.commentMessage.setText(comment.getMessage());
        //holder.binding.rating.setText(); TODO: We haven't implemented comment's rating
        // TODO: Replies to comment
        //holder.binding.commentDate.setText(); TODO: We haven't implemented comment's date too
        holder.binding.likeCount.setText(comment.getNumberOfLikes());

        // TODO: Implementation of "liking" a comment.
        // NOTE: Some of this can be taken from the FavItemAdapter
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LayoutCommentCustomerViewBinding binding;
        public ViewHolder(LayoutCommentCustomerViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
