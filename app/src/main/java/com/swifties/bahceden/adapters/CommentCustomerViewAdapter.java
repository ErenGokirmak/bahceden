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
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.CommentApi;
import com.swifties.bahceden.databinding.LayoutCommentCustomerViewBinding;
import com.swifties.bahceden.models.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentCustomerViewAdapter extends RecyclerView.Adapter<CommentCustomerViewAdapter.ViewHolder> {
    List<Comment> comments;
    LayoutInflater inflater;
    Context context;
    public CommentCustomerViewAdapter(List<Comment> comments, LayoutInflater inflater, Context context) {
        this.comments = comments;
        this.inflater = inflater;
        this.context = context;
    }
    @NonNull
    @Override
    public CommentCustomerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommentCustomerViewAdapter.ViewHolder(LayoutCommentCustomerViewBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommentCustomerViewAdapter.ViewHolder holder, int position) {
        Comment comment = comments.get(position);
        Picasso.get().load(comment.getAuthor().getProfileImageURL().replace("localhost", "10.0.2.2")).into(holder.binding.commentImage);
        holder.binding.commentName.setText(comment.getAuthor().getName());
        holder.binding.commentMessage.setText(comment.getMessage());
        holder.binding.likeCount.setText(String.valueOf(comment.getCountOfLikes()));
        if (comment.getChildComment() == null)
        {
            holder.binding.commentReplyHolder.setVisibility(View.GONE);
        }
        else
        {
            holder.binding.commentReplyAuthor.setText(comment.getChildComment().getAuthor().getName());
            holder.binding.commentReply.setText(comment.getChildComment().getMessage());
        }
        if (comment.getAuthor().equals(AuthUser.getCustomer()))
        {
            holder.binding.commentDelete.setVisibility(View.VISIBLE);
            holder.binding.commentDelete.setOnClickListener(v -> {
                comments.remove(comment);
                notifyItemRemoved(position);
                RetrofitService.getApi(CommentApi.class).deleteCommentById(comment.getId()).enqueue(new Callback<Comment>() {
                    @Override
                    public void onResponse(Call<Comment> call, Response<Comment> response) {

                    }

                    @Override
                    public void onFailure(Call<Comment> call, Throwable t) {
                        throw new RuntimeException(t);
                    }
                });
            });
        }
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
