package com.example_game;
 
import android.app.Activity;
import android.os.Bundle;  
import android.view.View;  
import android.widget.Button;  
import android.widget.ImageView;  
import android.widget.TextView;  
  
  
public class MainActivity extends Activity implements View.OnClickListener {  
    private TextView text;  
    private ImageView pic0;  
    private ImageView pic1;  
    private ImageView pic2;  
    int[] imageIds = new int[]{R.drawable.cup_ok, R.drawable.cup_sorry,  
            R.drawable.cup_sorry};  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  
        pic0 = (ImageView) findViewById(R.id.pic0);  
        pic1 = (ImageView) findViewById(R.id.pic1);  
        pic2 = (ImageView) findViewById(R.id.pic2);  
        Button butplay = (Button) findViewById(R.id.butplay);  
        text = (TextView) findViewById(R.id.text);  
        pic0.setOnClickListener(this);  
        pic1.setOnClickListener(this);  
        pic2.setOnClickListener(this);  
        butplay.setOnClickListener(this);  
        replay();//开局先将杯子顺序打乱  
    }  
  
    @Override  
    public void onClick(View view) {  
        switch (view.getId()) {  
            case R.id.pic0:  
                //设置已打乱顺序的杯子图片  
                pic0.setImageDrawable(getResources().getDrawable(imageIds[0]));  
                pic1.setImageDrawable(getResources().getDrawable(imageIds[1]));  
                pic2.setImageDrawable(getResources().getDrawable(imageIds[2]));  
                if (imageIds[0] == R.drawable.cup_ok) {  
                    //判断是否猜中有小球的杯子  
                    text.setText("恭喜你，猜对了，祝你幸福！");  
                } else  
                    text.setText("很抱歉，猜错了，要不要再试一次？");  
                break;  
  
            case R.id.pic1:  
                pic0.setImageDrawable(getResources().getDrawable(imageIds[0]));  
                pic1.setImageDrawable(getResources().getDrawable( imageIds[1]));  
                pic2.setImageDrawable(getResources().getDrawable(imageIds[2]));  
                if (imageIds[1] == R.drawable.cup_ok) {  
                    text.setText("恭喜你，猜对了，祝你幸福！");  
                } else  
                    text.setText("很抱歉，猜错了，要不要再试一次？");  
                break;  
  
            case R.id.pic2:  
                pic0.setImageDrawable(getResources().getDrawable(imageIds[0]));  
                pic1.setImageDrawable(getResources().getDrawable(imageIds[1]));  
                pic2.setImageDrawable(getResources().getDrawable(imageIds[2]));  
                if (imageIds[2] == R.drawable.cup_ok) {  
                    text.setText("恭喜你，猜对了，祝你幸福！");  
                } else  
                    text.setText("很抱歉，猜错了，要不要再试一次？");  
                break;  
  
            case R.id.butplay:  
                replay();  
  
            default:  
                break;  
        }  
    }  
  
    public void replay() {  
        //点击再玩一次，恢复原有标题和杯子图片  
        text.setText(R.string.cup);  
        pic0.setImageDrawable(getResources().getDrawable(R.drawable.cup_default));  
        pic1.setImageDrawable(getResources().getDrawable( R.drawable.cup_default));  
        pic2.setImageDrawable(getResources().getDrawable(R.drawable.cup_default));  
  
        for (int i = 0; i < 3; i++) {  
            int temp = imageIds[i]; // 将数组元素i保存到临时变量中  
            int index = (int) (Math.random() * 2); // 生成一个随机数  
            imageIds[i] = imageIds[index]; // 将随机数指定的数组元素的内容赋给数组元素i  
            imageIds[index] = temp; // 将临时变量的值赋值给随机数组指定的那个数组元素  
        }  
    }  
}  