package org.techtown.mandk;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static org.techtown.mandk.R.id.shopping;

/**
 * Created by LG on 2017-12-01.
 */

public class Order1 extends AppCompatActivity {

    private int mQuantity = 1;
    int i;

    FirebaseAuth mAuth;
    DatabaseReference databaseCharts;

    TextView textViewMenuName;
    TextView textViewMenuPrice;
    Button buttonShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("製品注文");

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() != null)
        {
            databaseCharts = FirebaseDatabase.getInstance().getReference().child(mAuth.getCurrentUser().getUid());
        } else {
            databaseCharts = FirebaseDatabase.getInstance().getReference();
        }

        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");
        Resources res = getResources();


        // イメージ
        LinearLayout layout = (LinearLayout)findViewById(R.id.porm);
        int id_background = res.getIdentifier("dessert_img" + tag, "string", getPackageName());
        String background = res.getString(id_background);
        int id_img = res.getIdentifier(background, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(id_img);
        layout.setBackground(drawable);


        // 商品の名前
        textViewMenuName = (TextView)findViewById(R.id.name);
        int id_name = res.getIdentifier("dessert_name" + tag, "string", getPackageName());
        String name = res.getString(id_name);
        textViewMenuName.setText(name);

        // 値段
        textViewMenuPrice = (TextView)findViewById(R.id.price);
        final int id_price = res.getIdentifier("dessert_price" + tag, "string", getPackageName());
        final String price = res.getString(id_price);
        textViewMenuPrice.setText(price);


        TextView title = (TextView)findViewById(R.id.price);
        String title01 = title.getText().toString();
        final int title02 = Integer.parseInt(title01);

        i = title02;
        price(i*mQuantity);

        Button increment = (Button)findViewById(R.id.increment);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQuantity++;
                display(mQuantity);
                price(i*mQuantity);

            }
        });

        Button decrement = (Button)findViewById(R.id.decrement);
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQuantity--;
                if (mQuantity < 1){
                    mQuantity = 1;
                }
                display(mQuantity);
                price(mQuantity*i);

            }
        });

        buttonShopping = (Button)findViewById(shopping);
        buttonShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // データベースにデータを入れるコード
                if(mAuth.getCurrentUser() != null)
                {
                    String menuName = textViewMenuName.getText().toString().trim();
                    String menuNum =  String.valueOf(mQuantity);
                    String menuPrice = textViewMenuPrice.getText().toString().trim();

                    if(!TextUtils.isEmpty(menuName) && !TextUtils.isEmpty(menuNum) && !TextUtils.isEmpty(menuPrice)) {
                        String orderId = databaseCharts.push().getKey();

                        Chart chart = new Chart(orderId,menuName,menuNum,menuPrice);

                        databaseCharts.child(orderId).setValue(chart);

                        Toast.makeText(getApplicationContext(),"買い物かごに入れました。",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"買い物かごに入れることに失敗しました。",Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext()," ログインすると,買い物かごの機能を使うことができます。",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private void display(int number){
        TextView quantityTextView = (TextView)findViewById(R.id.qiantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void price(int number){
        TextView priceTextView = (TextView)findViewById(R.id.price);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
