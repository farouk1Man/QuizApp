package com.example.android.qiuzapp10;

import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;



public class MainActivity2 extends AppCompatActivity
{
    //Quest1_opt
    RadioGroup rg1;
    RadioButton opt1a;
    RadioButton opt1b;
    RadioButton opt1c;

    //Quest2_opt
    CheckBox chkbxq2a;
    CheckBox chkbxq2b;
    CheckBox chkbxq2c;
    CheckBox chkbxq2d;
    CheckBox chkbxq2e;

    //Quest3_opt
    EditText txt1;

    //Quest 4_opt
    RadioGroup rg4;
    RadioButton opt4a;
    RadioButton opt4b;
    RadioButton opt4c;

    //Quest 5_opt
    EditText txt2;

    int quest_no;
    int score;
    String lb;
    LinearLayout options_pane;
    ImageView img_Area;

    Button nxtBtnToSubmit;

    CheckBoxListener chkHandler;

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        lb="Questions from the world of ICT";
        this.setContentView(R.layout.activity_main2);
        score=0;

        /**need to keep track of the next button
        * so that its label canbe changed to either
        * "NEXT" or "SUBMIT" */

        //connecting id(s) to the Views component declared
        nxtBtnToSubmit=findViewById(R.id.next_btn);
        img_Area=findViewById(R.id.img_pane);
        options_pane=findViewById(R.id.options_pane);

        quest_no=1;
        //Instantiating listener for CheckBox
        chkHandler=new CheckBoxListener(getApplicationContext());

        instantiateOptions();

        refreshContent();
    }

    public void previousButtonClicked(View v)
    {
        if(!(quest_no==1|quest_no<1))
            quest_no--;

        refreshContent();
    }
    public void nextButtonClicked(View v)
    {
        if(!(quest_no==5|quest_no>5))
            quest_no++;

        if(((Button)v).getText().equals("Submit"))
        {
            //calculate the Result
            score=calculateScore();
            if(score==5)
                Toast.makeText(this,"Congratulations! your score is "+score,Toast.LENGTH_SHORT).show();
            else if(score<5)
                Toast.makeText(this,"Your score is "+score+". Try Again!",Toast.LENGTH_SHORT).show();
        }

        refreshContent();
    }

    public void refreshContent()
    {
       options_pane.removeAllViews();

       //Check for when at the last question
        if(quest_no==5)
            nxtBtnToSubmit.setText("Submit");
        else
            nxtBtnToSubmit.setText("Next");




        TextView header_lb=findViewById(R.id.ques_header_dp); //header_lb is the text in the Red Bar
        TextView quest_dp=findViewById(R.id.quest_dp); //quest_dp is a reference to the TextView that
        img_Area.setImageResource(android.R.color.background_light);

        //Laying out the Questions and Answers depending on the current question number
        switch(quest_no)
        {
            case 1:
                header_lb.setText(lb+" 1 of 5");
                quest_dp.setText(R.string.quest_1);
                options_pane.addView(rg1);
                break;
            case 2:
                header_lb.setText(lb+" 2 of 5");
                quest_dp.setText(R.string.quest_2);
                options_pane.addView(chkbxq2a); options_pane.addView(chkbxq2b);
                options_pane.addView(chkbxq2c); options_pane.addView(chkbxq2d);
                options_pane.addView(chkbxq2e);
                break;
            case 3:
                header_lb.setText(lb+" 3 of 5");
                quest_dp.setText(R.string.quest_3);
                img_Area.setImageResource(R.drawable.img2);
                options_pane.addView(txt1);
                break;
            case 4:
                header_lb.setText(lb+" 4 of 5");
                quest_dp.setText(R.string.quest_4);
                options_pane.addView(rg4);
                break;
            case 5:
                header_lb.setText(lb+" 5 of 5");
                quest_dp.setText(R.string.quest_5);
                options_pane.addView(txt2);
                break;
        }
    }

    public void instantiateOptions()
    {
        rg1=new RadioGroup(this);
        opt1a=new RadioButton(this);
        opt1b=new RadioButton(this);
        opt1c=new RadioButton(this);
        opt1a.setText("Windows"); opt1b.setText("Linux"); opt1c.setText("Ubuntu");
        rg1.addView(opt1a);rg1.addView(opt1b);rg1.addView(opt1c);

        chkbxq2a=new CheckBox(this);
        chkbxq2b=new CheckBox(this);
        chkbxq2c=new CheckBox(this);
        chkbxq2d=new CheckBox(this);
        chkbxq2e=new CheckBox(this);

        chkbxq2a.setOnCheckedChangeListener(chkHandler);
        chkbxq2b.setOnCheckedChangeListener(chkHandler);
        chkbxq2c.setOnCheckedChangeListener(chkHandler);
        chkbxq2d.setOnCheckedChangeListener(chkHandler);
        chkbxq2e.setOnCheckedChangeListener(chkHandler);

        chkbxq2a.setText("lttp");  chkbxq2b.setText("https");  chkbxq2c.setText("ftp");  chkbxq2d.setText("apt");
        chkbxq2e.setText("tftp");

        txt1=new EditText(this);
        txt1.setSingleLine();
        txt1.setHint("type your answer here...");

        rg4=new RadioGroup(this);
        opt4a=new RadioButton(this);
        opt4b=new RadioButton(this);
        opt4c=new RadioButton(this);
        opt4a.setText("Local Associative Network");  opt4b.setText("Local Area Network");  opt4c.setText("Local Anonimous Network");
        rg4.addView(opt4a); rg4.addView(opt4b); rg4.addView(opt4c);

        txt2=new EditText(this);
        txt2.setSingleLine();
        txt2.setHint("type your answer here...");
    }

    public int calculateScore()
    {
        int score=0;

        //Compare user answers with a set of values and increase the score by one if true
        if(opt1b.isChecked())
            score++;

        if(chkbxq2b.isChecked() && chkbxq2c.isChecked() && chkbxq2e.isChecked())
            score++;

        String txt=(txt1.getText()).toString();
        if(txt.equals("ROUTER")||txt.equals("router")||txt.equals("Router"))
            score++;

        if(opt4b.isChecked())
            score++;

        txt=(txt2.getText()).toString();
        if(txt.equals("Internet Service Provider")||txt.equals("internet service provider")||txt.equals("INTERNET SERVICE PROVIDER"))
            score++;


        return score;

    }
}
