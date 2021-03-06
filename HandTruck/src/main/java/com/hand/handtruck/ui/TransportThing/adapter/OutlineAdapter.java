package com.hand.handtruck.ui.TransportThing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hand.handtruck.R;
import com.hand.handtruck.ui.TransportThing.bean.TransportBean;

import java.util.List;

/*
 * 
 */
public class OutlineAdapter extends BaseAdapter {

	private  List<TransportBean> mList;
	private Context context;
	private LayoutInflater inflater;

	public OutlineAdapter(Context context, List<TransportBean> list){
		this.context = context;
		inflater = LayoutInflater.from(context);
		this.mList=list;
	}

	@Override
	public int getCount() {
		if (mList != null ){
			return mList.size();
		}else{
			return 0;
		}
	}

    public void updateListView(List<TransportBean> list){
        this.mList = list;
        notifyDataSetChanged();
    }
	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHold viewHold = null;
        TransportBean item = mList.get(position);
		if (convertView == null) {
			viewHold = new ViewHold();
			convertView =inflater.inflate(R.layout.item_msg_alram, null);
			viewHold.tv_order_number=(TextView)convertView.findViewById(R.id.tv_order_number);
			viewHold.tv_car_number=(TextView)convertView.findViewById(R.id.tv_car_number);
			viewHold.tv_cust_name=(TextView)convertView.findViewById(R.id.tv_cust_name);
			viewHold.tv_close_time=(TextView)convertView.findViewById(R.id.tv_close_time);
            viewHold.tv_open_time=(TextView)convertView.findViewById(R.id.tv_open_time);
            viewHold.tv_leave_address=(TextView)convertView.findViewById(R.id.tv_leave_address);
			convertView.setTag(viewHold);
		} else {
			viewHold = (ViewHold) convertView.getTag();
		}
		if(item != null ){
		    String orderCode=item.getOrderCode();
			viewHold.tv_order_number.setText(orderCode+"");
			String carNumber=item.getCarNumber();
            viewHold.tv_car_number.setText(carNumber+"");
            String name=item.getCustName();
			viewHold.tv_cust_name.setText(name+"");
            String offDate=item.getOffTime();
//            String chaDate=item.getOffSecond();

			String onDate=item.getOnTime();

			viewHold.tv_close_time.setText(offDate+"");
			viewHold.tv_leave_address.setText(item.getAddress()+"");

			viewHold.tv_open_time.setText(onDate+"");
//			if(!Tools.isEmpty(offDate) && Tools.isEmpty(chaDate)){
//
//				String startDate= DateUtil.doStartDate(offDate,chaDate);
//				viewHold.tv_open_date.setText(startDate+"");
//
//				String dateStr= DateUtil.doHaveDate(chaDate);
//				viewHold.tv_outline_date.setText(dateStr+"");
//			}

		}
		return convertView;
	}

	class ViewHold {
		TextView tv_order_number;
		TextView tv_car_number;
        TextView tv_cust_name;
		TextView tv_close_time;
		TextView tv_open_time;
		TextView tv_leave_address;
	}
}
