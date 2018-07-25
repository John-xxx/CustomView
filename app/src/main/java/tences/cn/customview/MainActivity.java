package tences.cn.customview;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

public class MainActivity extends Activity implements CheckBox.OnCheckedChangeListener {

    CheckBox[] checkBoxes = new CheckBox[4];
    LinearLayoutCompat status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = (LinearLayoutCompat) findViewById(R.id.layout_status);
        setStatus();

    }


    private void setStatus() {
        checkBoxes[0] = (CheckBox) findViewById(R.id.status_one);
        checkBoxes[1] = (CheckBox) findViewById(R.id.status_two);
        checkBoxes[2] = (CheckBox) findViewById(R.id.status_three);
        checkBoxes[3] = (CheckBox) findViewById(R.id.status_four);
        checkBoxes[0].setOnCheckedChangeListener(this);
        checkBoxes[1].setOnCheckedChangeListener(this);
        checkBoxes[2].setOnCheckedChangeListener(this);
        checkBoxes[3].setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            //距离
            case R.id.status_one:

                View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popup_listview, null, false);
                PopWindowUtil.getInstance().makePopupWindow(MainActivity.this,status,contentView,R.color.colorAccent)
                        .showLocationWithAnimation(MainActivity.this,status,ActionBar.LayoutParams.MATCH_PARENT,0,R.style.popmenu_animation);
                if (isChecked && checkBoxes[3].isChecked()) {
                    checkBoxes[3].setChecked(false);
//                    close();
//                    refreshData();
//                    show();
                } else if (isChecked && !checkBoxes[3].isChecked()) {
//                    refreshData();
//                    show();
                } else {
//                    close();
                }
                break;
            //销量
            case R.id.status_two:
                if (isChecked){
                    checkBoxes[2].setChecked(false);
                }else {

                }
                checkBoxes[0].setChecked(false);
                checkBoxes[3].setChecked(false);
//                close();
                break;
            //评分
            case R.id.status_three:
                if (isChecked){
                    checkBoxes[1].setChecked(false);
                }else {

                }
                checkBoxes[0].setChecked(false);
                checkBoxes[3].setChecked(false);
//                close();
                break;
            //筛选
            case R.id.status_four:
                if (isChecked && checkBoxes[0].isChecked()) {
                    checkBoxes[0].setChecked(false);
//                    close();
//                    refreshData();
//                    show();
                } else if (isChecked && !checkBoxes[0].isChecked()) {
//                    refreshData();
//                    show();
                } else {
//                    close();
                }
                break;
            default:
        }
    }

    /**
     * popupWindow
     */
    private void popupWindowShow() {
        // 用于PopupWindow的View
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popup_listview, null, false);
        // 创建PopupWindow对象，其中：
        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
        PopupWindow window = new PopupWindow(contentView, ActionBar.LayoutParams.MATCH_PARENT, 100, true);
        // 设置PopupWindow的背景
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        window.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        window.setTouchable(true);
        // 显示PopupWindow，其中：
        // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
        window.showAsDropDown(status, 200, 300);
        // 或者也可以调用此方法显示PopupWindow，其中：
        // 第一个参数是PopupWindow的父View，第二个参数是PopupWindow相对父View的位置，
        // 第三和第四个参数分别是PopupWindow相对父View的x、y偏移
        // window.showAtLocation(parent, gravity, x, y);
    }
}
