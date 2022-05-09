package br.com.renner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import br.com.renner.model.Slider;

public class MainActivity extends AppCompatActivity{

    private List<Slider> listItems;
    private ViewPager page;
    private TabLayout tabLayout;
    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        page      = findViewById(R.id.my_pager);
        tabLayout = findViewById(R.id.tab);

        listItems = new ArrayList<>() ;
        listItems.add(new Slider(R.drawable.imgu,""));
        listItems.add(new Slider(R.drawable.imgd,""));
        listItems.add(new Slider(R.drawable.imgt,""));
        listItems.add(new Slider(R.drawable.imgq,""));
        listItems.add(new Slider(R.drawable.imgc,""));
        listItems.add(new Slider(R.drawable.imgs,""));
        listItems.add(new Slider(R.drawable.imgse,""));
        listItems.add(new Slider(R.drawable.imgn,""));
        listItems.add(new Slider(R.drawable.imgdz,""));
        listItems.add(new Slider(R.drawable.img11,""));

        Itens itemsPager_adapter = new Itens(this, listItems);
        page.setAdapter(itemsPager_adapter);

        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new carouselTimer(),2000,3000);
        tabLayout.setupWithViewPager(page,true);

    }

    public class carouselTimer extends TimerTask {
        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page.getCurrentItem()< listItems.size()-1) {
                        page.setCurrentItem(page.getCurrentItem()+1);
                    }
                    else
                        page.setCurrentItem(0);
                }
            });
        }
    }

  public static void GetVenda(int id){
      Intent i = new Intent(mContext, VendaActivity.class);
      i.putExtra("imagem", id);
      mContext.startActivity(i);

  }

}


