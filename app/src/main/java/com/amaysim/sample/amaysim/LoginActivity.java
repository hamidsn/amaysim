package com.amaysim.sample.amaysim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.amaysim.sample.amaysim.managers.DataCacheMgr;
import com.amaysim.sample.amaysim.utils.ApiParser;

import org.json.JSONException;
import org.json.JSONObject;

import static com.amaysim.sample.amaysim.AmaysimApplication.getAppContext;
import static com.amaysim.sample.amaysim.utils.AssetsUtils.loadJSONFromAsset;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<JSONObject> {

    private static final int REQUEST_READ_CONTACTS = 0;
    private static final String TAG = "LOGINACTIVITY";
    private UserLoginTask mAuthTask = null;
    private AutoCompleteTextView mmsnView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        getLoaderManager().initLoader(0, null, this);

        mmsnView = (AutoCompleteTextView) findViewById(R.id.msn);
        // populateAutoComplete();

        Button mEmailSignInButton = (Button) findViewById(R.id.msn_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }
        // Reset errors.
        mmsnView.setError(null);
        // Store values at the time of the login attempt.
        String msnNumbers = mmsnView.getText().toString();
        boolean cancel = false;
        View focusView = null;

        // Check for a valid email address.
        if (TextUtils.isEmpty(msnNumbers)) {
            mmsnView.setError(getString(R.string.error_field_required));
            focusView = mmsnView;
            cancel = true;
        } else if (!isNumnerValid(msnNumbers)) {
            mmsnView.setError(getString(R.string.error_invalid_msn));
            focusView = mmsnView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(msnNumbers);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isNumnerValid(String number) {
        //TODO: Replace this with your own logic
        return ((number.matches("[0-9]+") && number.length() > 2) ? true : false);
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public Loader<JSONObject> onCreateLoader(int i, Bundle bundle) {
        return new AssetsLoader(this);
    }


    @Override
    public void onLoadFinished(Loader<JSONObject> loader, JSONObject jObject) {
        ApiParser.parseData(jObject);
    }

    @Override
    public void onLoaderReset(Loader<JSONObject> loader) {

    }

    public static class AssetsLoader extends AsyncTaskLoader<JSONObject> {

        private JSONObject myData;
        private String ERROR_MESSAGE = "Json read error: ";

        public AssetsLoader(Context context) {
            super(context);
        }

        @Override
        public JSONObject loadInBackground() {
            JSONObject jsonObj = null;
            try {
                jsonObj = new JSONObject(loadJSONFromAsset());
            } catch (JSONException e) {
                Log.e(TAG , ERROR_MESSAGE + e.getMessage());
            }
            return jsonObj;
        }

        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            if (myData != null) {
                // If we currently have a result available, deliver it immediately.
                deliverResult(myData);
            }
            if (myData == null) {
                forceLoad();
            }
        }

        @Override
        public void deliverResult(JSONObject data) {
            myData = data;
            if (data != null) {
                super.deliverResult(data);
            }
        }
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mMsn;

        UserLoginTask(String msn) {
            mMsn = msn;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                return false;
            }

            if (!mMsn.equals(DataCacheMgr.getLogin_details())) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                Intent intent = new Intent(getAppContext(), InfoActivity.class);
                startActivity(intent);
                finish();
            } else {
                mmsnView.setError(getString(R.string.error_wrong_msn));
                mmsnView.requestFocus();
                // TODO: register the new account here.
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}

