package alexander.dmtaiwan.com.masterdetaillayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lenovo on 3/6/2016.
 */
public class MainFragment extends Fragment{
    private Boolean mTablet;
    private Button mButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mButton = (Button) rootView.findViewById(R.id.clickMe);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTablet = ((MainActivity) getActivity()).isTablet();
                if(!mTablet) {
                    //This is phone mode, create an intent to launch DetailActivity.  Attach EXTRA
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("EXTRA", "This fragment is attahced to a Detail Activity");
                    startActivity(intent);
                }else{
                    //This is tablet mode, tell MainActivity to replace the fragment in Container
                    ((MainActivity)getActivity()).replaceFragment();
                }
            }
        });
        return rootView;
    }
}
