package dev.trung.readwritefile.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dev.trung.readwritefile.R;
import dev.trung.readwritefile.databinding.FilesItemLayoutBinding;
import dev.trung.readwritefile.model.File;

/**
 * Created by trungnv on 7/29/2016.
 */

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.FileHolder> {

    public interface OnClickItemListener {
        void onClickItem(File file);
    }

    private List<File> mFiles;
    private OnClickItemListener listener;

    public FileAdapter(List<File> mFiles, OnClickItemListener listener) {
        this.mFiles = mFiles;
        this.listener = listener;
    }

    @Override
    public FileHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.files_item_layout, parent, false);
        return new FileHolder(view);
    }

    @Override
    public void onBindViewHolder(FileHolder holder, int position) {
        final File file = getFile(position);
        holder.getBinding().txtNameFile.setText(file.getNameFile());
        holder.getBinding().imgFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickItem(file);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFiles != null ? mFiles.size() : 0;
    }

    public File getFile(int position) {
        return mFiles.get(position);
    }

    public class FileHolder extends RecyclerView.ViewHolder {
        private FilesItemLayoutBinding mBinding;

        public FileHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public FilesItemLayoutBinding getBinding() {
            return mBinding;
        }
    }
}
