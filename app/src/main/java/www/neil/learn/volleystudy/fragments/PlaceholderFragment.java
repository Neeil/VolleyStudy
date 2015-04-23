package www.neil.learn.volleystudy.fragments;

/**
 * @authoer : fg086897
 * @created time   : 4/23/2015
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import www.neil.learn.volleystudy.MainActivity;
import www.neil.learn.volleystudy.R;
import www.neil.learn.volleystudy.application.AppHandler;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    Button btGetJson;
    Button btGetImage;

    TextView tvJsonData;
    ImageView ivImage;

    AppHandler appHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        appHandler = AppHandler.getInstance();

        btGetJson = (Button)rootView.findViewById(R.id.bt_getJson);
        btGetImage = (Button)rootView.findViewById(R.id.bt_getImage);

        tvJsonData = (TextView)rootView.findViewById(R.id.tv_Json);
        ivImage = (ImageView)rootView.findViewById(R.id.iv_Image);

        btGetJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest("http://iot-tecloud-ap-ne-1-dev.elasticbeanstalk.com/devices/",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                tvJsonData.setText(response.toString());
                                Log.d("TAG", response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
                });

                appHandler.addToRequestQueue(stringRequest);
            }
        });


        btGetImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

        return rootView;
    }
}