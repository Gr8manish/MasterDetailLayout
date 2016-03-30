package alexander.dmtaiwan.com.masterdetaillayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MainFragment.FragmentInterface{
    private Boolean mTabletMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = MainFragment.newInstance(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, mainFragment).commit();

        if(findViewById(R.id.container)!= null){
            mTabletMode = true;
            DetailFragment detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, detailFragment).commit();
        }
    }

    public boolean isTablet() {
        return mTabletMode;
    }

    public void replaceFragment() {
        Log.i("tab", "replace");
        Bundle args = new Bundle();
        args.putString("ARGUMENTS", "Created from MainActivity");
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, detailFragment).commit();
    }
}
