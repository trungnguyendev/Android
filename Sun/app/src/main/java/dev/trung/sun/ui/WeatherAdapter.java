package dev.trung.sun.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.trung.sun.R;
import dev.trung.sun.databinding.ForecastItemBinding;
import dev.trung.sun.model.SimpleForecastDay;

/**
 * Created by trungnv on 8/16/2016.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherHolder> {
    private List<SimpleForecastDay> list;
    private Context mContext;

    public WeatherAdapter(List<SimpleForecastDay> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_item, parent, false);
        return new WeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherHolder holder, int position) {
        SimpleForecastDay model = getItem(position);
        holder.mBinding.txtTime.setText(model.getDate().getHour() + ":" + model.getDate().getMin() + " " + model.getDate().getAmpm());
        holder.mBinding.txtDayOfWeek.setText(model.getDate().getWeekdayShort());
        Picasso.with(mContext).load(model.getIconUrl()).into(holder.mBinding.imgIcon);
        holder.mBinding.txtHigh.setText(String.valueOf(model.getHigh().getCelsius()));
        holder.mBinding.txtLow.setText(String.valueOf(model.getLow().getCelsius()));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public SimpleForecastDay getItem(int p) {
        return list.get(p);
    }

    public class WeatherHolder extends RecyclerView.ViewHolder {
        private ForecastItemBinding mBinding;

        public WeatherHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public ForecastItemBinding getmBinding() {
            return mBinding;
        }
    }
}
