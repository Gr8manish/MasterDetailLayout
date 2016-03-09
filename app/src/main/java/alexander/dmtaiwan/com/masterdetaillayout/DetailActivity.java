package alexander.dmtaiwan.com.masterdetaillayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lenovo on 3/9/2016.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getIntent() != null) {
            //Get EXTRA from intent and attach to Fragment as Argument
            String text = getIntent().getStringExtra("EXTRA");
            Bundle args = new Bundle();
            args.putString("ARGUMENTS", text);
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, detailFragment).commit();
        }
    }
}
