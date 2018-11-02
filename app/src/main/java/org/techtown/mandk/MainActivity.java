package org.techtown.mandk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Stack;

import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;
    private BroadcastReceiver broadcastReceiver;

    public Button LoginIntent;
    public Button CreateAccountIntent;
    public Button LogoutIntent;
    public TextView HelloText;
    public int NowIndex = 0;
    Stack<Integer> stack = new Stack<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this,CheckAppQuit.class));
        setContentView(R.layout.activity_main);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };
        if(SharedPrefManager.getInstance(this).getToken() != null){
            Log.d("myfcmtokenshared",SharedPrefManager.getInstance(this).getToken());
        }
        registerReceiver(broadcastReceiver, new IntentFilter(MyFirebaseInstanceIdService.TOKEN_BROADCAST));
        stack.push(0);
        
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View HeaderView = navigationView.getHeaderView(0);
        LoginIntent = (Button)HeaderView.findViewById(R.id.LoginBtn);
        CreateAccountIntent = (Button)HeaderView.findViewById(R.id.createAccBtn);
        LogoutIntent = (Button)HeaderView.findViewById(R.id.logoutBtn);
        HelloText = (TextView)HeaderView.findViewById(R.id.HelloText);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() != null){
            FirebaseUser user = mAuth.getCurrentUser();
            String customerName = user.getDisplayName();

            HelloText.setText(customerName+"さま!歓迎します!");
            LoginIntent.setVisibility(View.INVISIBLE);

            CreateAccountIntent.setVisibility(View.INVISIBLE);

            LogoutIntent.setVisibility(View.VISIBLE);

        } else {
            HelloText.setText("로그인 해주십시오.");
        }

        // ログインのアクティビティに転換
        LoginIntent.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        // 会員加入のアクティビティに転換
        CreateAccountIntent.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        // ログアウト
        LogoutIntent.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                mAuth.signOut();
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // メインページの登録
        pager p = new pager();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.constraintlayout_for_fragment,p,p.getTag()).commit();
    }

    private void startActivity(Intent intent) {
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            int TempPop = stack.pop();
            if(NowIndex ==0 && TempPop == 0)
            {
                stack.push(0);
                moveTaskToBack(TRUE);
            }
            else if (NowIndex == 0 && TempPop != 0)
            {
                if (TempPop == 1) {
                    NowIndex = 1;
                    GalleryFragment galleryFragment = new GalleryFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.constraintlayout_for_fragment, galleryFragment, galleryFragment.getTag()).commit();
                }
            }
            else if (NowIndex == 1)
            {
                if(TempPop == 0)
                {
                    NowIndex = 0;
                    pager p2 = new pager();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.constraintlayout_for_fragment,p2,p2.getTag()).commit();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            if(NowIndex == 0)
            {
            } else {
                stack.push(NowIndex);
                NowIndex = 0;
            }

            pager p2 = new pager();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.constraintlayout_for_fragment,p2,p2.getTag()).commit();
        } else if (id == R.id.nav_gallery) {
            if(NowIndex == 1)
            {
            } else {
                stack.push(NowIndex);
                NowIndex = 1;
            }

            GalleryFragment galleryFragment = new GalleryFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.constraintlayout_for_fragment,galleryFragment,galleryFragment.getTag()).commit();
        } else if (id == R.id.nav_slideshow) {
            Intent it = new Intent(this,Shopping.class);
            startActivity(it);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
