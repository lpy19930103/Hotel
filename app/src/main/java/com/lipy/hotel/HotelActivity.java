package com.lipy.hotel;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.lipy.common.base.BaseActivity;
import com.lipy.common.base.HotelConstants;
import com.lipy.common.bean.DayTimeEntity;
import com.orhanobut.hawk.Hawk;

import java.text.SimpleDateFormat;


public class HotelActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mHotelHomeBanner;
    private TextView mHotelHomeCityName;
    private TextView mHotelHomeLocation;
    private TextView mHotelHomeStartTime;
    private TextView mHotelHomeStartSub;
    private TextView mHotelHomeDay;
    private TextView mHotelHomeEndTime;
    private TextView mHotelHomeEndSub;
    private TextView mHotelHomeSearch;
    private String location;

    private DayTimeEntity startTime;
    private DayTimeEntity endTime;
    private String cityCode;//1201
    private long ArrivalDate;
    private long DepartureDate;

    @Override
    protected int loadViewLayout() {
        return R.layout.activity_hotel;
    }

    @Override
    protected void initView() {
        setTitle("酒店预订");
        mHotelHomeBanner = (ImageView) findViewById(R.id.hotel_home_banner);
        mHotelHomeCityName = (TextView) findViewById(R.id.hotel_home_city_name);
        mHotelHomeLocation = (TextView) findViewById(R.id.hotel_home_location);
        mHotelHomeStartTime = (TextView) findViewById(R.id.hotel_home_start_time);
        mHotelHomeStartSub = (TextView) findViewById(R.id.hotel_home_start_sub);
        mHotelHomeDay = (TextView) findViewById(R.id.hotel_home_day);
        mHotelHomeEndTime = (TextView) findViewById(R.id.hotel_home_end_time);
        mHotelHomeEndSub = (TextView) findViewById(R.id.hotel_home_end_sub);
        mHotelHomeSearch = (TextView) findViewById(R.id.hotel_home_search);
    }

    @Override
    protected void initListener() {
        findViewById(R.id.hotel_select_day).setOnClickListener(this);
        mHotelHomeBanner.setOnClickListener(this);
        mHotelHomeLocation.setOnClickListener(this);
        mHotelHomeCityName.setOnClickListener(this);
        mHotelHomeSearch.setOnClickListener(this);
        findViewById(R.id.hotel_home_next).setOnClickListener(this);
        findViewById(R.id.edit_clear).setOnClickListener(this);
        mHotelHomeSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                findViewById(R.id.edit_clear).setVisibility(StringUtils.isEmpty(editable.toString()) ? View.GONE : View.VISIBLE);
            }
        });
    }

    @Override
    protected void click(View view) {
        int i = view.getId();
        if (i == R.id.hotel_home_banner) {
        } else if (i == R.id.hotel_select_day) {
        } else if (i == R.id.hotel_home_location) {
            initAmap();
        } else if (i == R.id.hotel_home_city_name) {
        } else if (i == R.id.hotel_home_search) {
        } else if (i == R.id.hotel_home_next) {
        } else if (i == R.id.edit_clear) {
            mHotelHomeSearch.setText("");
        }
    }

    private void initAmap() {

    }

    @Override
    protected void initLocalData() {

        long nowMills = TimeUtils.getNowMills();
        long tomorrow = nowMills + 86400000;
        if (Hawk.contains(HotelConstants.ARRIVALDATE) && Hawk.contains(HotelConstants.DEPARTUREDATE)) {
            nowMills = Hawk.get(HotelConstants.ARRIVALDATE);
            tomorrow = Hawk.get(HotelConstants.DEPARTUREDATE);
        }
        mHotelHomeStartTime.setText(TimeUtils.millis2String(nowMills, new SimpleDateFormat("MM.dd")));
        mHotelHomeEndTime.setText(TimeUtils.millis2String(tomorrow, new SimpleDateFormat("MM.dd")));
        ArrivalDate = nowMills;
        DepartureDate = tomorrow;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == HotelConstants.CALENDAR_REQ_CODE && resultCode == RESULT_OK && data != null) {
            startTime = (DayTimeEntity) data.getSerializableExtra("START_TIME");
            endTime = (DayTimeEntity) data.getSerializableExtra("END_TIME");
            mHotelHomeStartTime.setText(startTime.getMonth() + "." + startTime.getDay());
            mHotelHomeStartSub.setText(TimeUtils.getChineseWeek(startTime.getTime(), new SimpleDateFormat("yyyy-MM-dd")));
            mHotelHomeEndTime.setText(endTime.getMonth() + "." + endTime.getDay());
            mHotelHomeEndSub.setText(TimeUtils.getChineseWeek(endTime.getTime(), new SimpleDateFormat("yyyy-MM-dd")));
            mHotelHomeDay.setText(TimeUtils.getTimeSpan(startTime.getTime(), endTime.getTime(), new SimpleDateFormat("yyyy-MM-dd"), TimeConstants.DAY) + "晚");
            ArrivalDate = TimeUtils.string2Millis(startTime.getTime(), new SimpleDateFormat("yyyy-MM-dd"));
            DepartureDate = TimeUtils.string2Millis(endTime.getTime(), new SimpleDateFormat("yyyy-MM-dd"));

            Hawk.put(HotelConstants.ARRIVALDATE, ArrivalDate);
            Hawk.put(HotelConstants.ARRIVALDATE, DepartureDate);

        } else if (requestCode == HotelConstants.SEARCH_REQ_CODE && data != null) {

        } else if (requestCode == HotelConstants.CITY_REQ_CODE && resultCode == RESULT_OK && data != null) {

        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}
