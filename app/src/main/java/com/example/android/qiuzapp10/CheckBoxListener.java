package com.example.android.qiuzapp10;

import android.widget.*;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.content.Context;

public class CheckBoxListener implements OnCheckedChangeListener
{
    Context context;
    int count;

    public CheckBoxListener(Context context)
    {
        this.context=context;
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked&&count==3)
        {
            buttonView.setChecked(false);
            (Toast.makeText(context,"Maximum of 3 options should be checked",Toast.LENGTH_SHORT)).show();

        }
        else if(isChecked)
            count++;
        else if(!(isChecked))
            count--;
    }
}
