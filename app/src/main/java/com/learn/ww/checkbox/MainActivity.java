package com.learn.ww.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 声明控件
    private CheckBox chkJava, chkAndroid, chkArm;
    private TextView tvChoice;
    private StringBuilder textContent = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化控件
        initControl();
        CheckedChangeListener listener = new CheckedChangeListener();
        // 为复选框添加onChange事件监听
        chkArm.setOnCheckedChangeListener(listener);
        chkAndroid.setOnCheckedChangeListener(listener);
        chkJava.setOnCheckedChangeListener(listener);
    }

    private void initControl() {
        chkArm = findViewById(R.id.chkArm);
        chkAndroid = findViewById(R.id.chkAndroid);
        chkJava = findViewById(R.id.chkJava);
        tvChoice = findViewById(R.id.tvChoice);
    }

    class CheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.chkJava:
                    changeCheckedBox("Java ", isChecked);
                    break;
                case R.id.chkAndroid:
                    changeCheckedBox("Android ", isChecked);
                    break;
                case R.id.chkArm:
                    changeCheckedBox("Arm ", isChecked);
                    break;
                default:
                    break;
            }
            tvChoice.setText("当前选择的课程有：" + textContent);
        }

        private void changeCheckedBox(String checkedCourse, Boolean isChecked) {
            if (isChecked) {
                textContent.append(checkedCourse);
            } else {
                int index = textContent.indexOf(checkedCourse);
                if (index != -1) {
                    int endIndex = index + checkedCourse.length();
                    textContent.delete(index, endIndex);
                }
            }
        }
    }
}
