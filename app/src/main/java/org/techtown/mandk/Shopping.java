package org.techtown.mandk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by LG on 2017-12-05.
 */


public class Shopping extends AppCompatActivity{

    FirebaseAuth mAuth;
    DatabaseReference databaseCharts;
    ListView listViewCharts;
    List<Chart> chartList;
    Button buttonOrder;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);
        setTitle("買い物かご");


        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() != null)
        {
            databaseCharts = FirebaseDatabase.getInstance().getReference().child(mAuth.getCurrentUser().getUid());
        } else {
            databaseCharts = FirebaseDatabase.getInstance().getReference();
        }

        listViewCharts = (ListView) findViewById(R.id.listViewCharts);

        chartList = new ArrayList<>();

        buttonOrder = (Button)findViewById(R.id.buttonOrder);
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 注文確定コード
                if(mAuth.getCurrentUser() != null)
                {
                    Iterator iterator = chartList.iterator();
                    while (iterator.hasNext()) {
                        Chart chart = (Chart) iterator.next();

                        String orderId = chart.getOrderId();

                        DatabaseReference tempDatabase = FirebaseDatabase.getInstance().getReference("order").child(mAuth.getCurrentUser().getUid());
                        tempDatabase.child(orderId).setValue(chart);
                    }

                    DatabaseReference databaseDeleteTemp = FirebaseDatabase.getInstance().getReference().child(mAuth.getCurrentUser().getUid());
                    databaseDeleteTemp.removeValue();

                    Toast.makeText(getApplicationContext(),"주문 하였습니다.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseCharts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                chartList.clear();
                for(DataSnapshot chartSnapshot : dataSnapshot.getChildren()){
                    Chart chart = chartSnapshot.getValue(Chart.class);

                    chartList.add(chart);
                }

                ChartList adapter = new ChartList(Shopping.this,chartList);
                listViewCharts.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
