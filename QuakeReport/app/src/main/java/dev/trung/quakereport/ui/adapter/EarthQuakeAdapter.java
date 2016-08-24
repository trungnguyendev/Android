package dev.trung.quakereport.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.List;

import dev.trung.quakereport.R;
import dev.trung.quakereport.databinding.EarthquakeListItemBinding;
import dev.trung.quakereport.model.EarthQuake;
import dev.trung.quakereport.util.Utils;

/**
 * Created by trungnv on 8/23/2016.
 */

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {
    private EarthquakeListItemBinding mBinding;

    public EarthQuakeAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }
        mBinding = DataBindingUtil.bind(view);
        EarthQuake model = getItem(position);
        mBinding.magnitude.setText(model.getmMagnitude());
        mBinding.locationOffset.setText(model.getmLocationOffset());
        mBinding.primaryLocation.setText(model.getmLocationPrimary());
        mBinding.date.setText(model.getmDate());
        mBinding.time.setText(model.getmTime());
        return view;
    }
}
