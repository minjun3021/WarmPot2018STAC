package com.example.kmj.warmpot_2018stac.activity;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;

        import com.example.kmj.warmpot_2018stac.R;
        import com.kakao.auth.ISessionCallback;
        import com.kakao.auth.Session;
        import com.kakao.network.ErrorResult;
        import com.kakao.usermgmt.UserManagement;
        import com.kakao.usermgmt.callback.MeV2ResponseCallback;
        import com.kakao.usermgmt.response.MeV2Response;
        import com.kakao.util.exception.KakaoException;
        import com.kakao.util.helper.log.Logger;

public class MainActivity extends AppCompatActivity {
    private SessionCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callback = new SessionCallback();

        Session.getCurrentSession().addCallback(callback);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);
    }

    private class SessionCallback implements ISessionCallback {

        @Override
        public void onSessionOpened() {
            Log.i("KAKAO", "Session Opened");
            requestMe();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                Logger.e(exception);
            }
        }

    }

    public void requestMe(){
        UserManagement.getInstance().me(new MeV2ResponseCallback() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {

            }

            @Override
            public void onSuccess(MeV2Response result) {
                // TODO 나중에 서버 연동할떄 서버에 보낼 access_token값
                String access_token = Session.getCurrentSession().getTokenInfo().getAccessToken();
                Log.e("token", access_token);
            }
        });
    }
}
