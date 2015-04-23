package www.neil.learn.volleystudy.application;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * @authoer : fg086897
 * @created time   : 4/23/2015
 */
public class AppHandler extends Application {

    private RequestQueue mQueue;
    private ImageLoader mImageLoader;
    private static AppHandler mInstance;

    private final String TAG = this.getClass().getName();


    @Override
    public void onCreate(){
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppHandler getInstance(){
        if(mInstance == null)
        {
            mInstance = new AppHandler();
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if(mQueue == null){
            mQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mQueue;
    }

    public ImageLoader getmImageLoader() {
        return mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }
}
