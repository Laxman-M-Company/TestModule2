package com.ford.oa.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ford.androidutils.permissions.PermissionsRequestHelper;
import com.ford.androidutils.permissions.PermissionsRequester;
import com.ford.ngsdnuser.providers.LocaleStorageProvider;
import com.ford.oa.BuildConfig;
import com.ford.oa.R;
import com.ford.oa.analytics.AdobeAnalyticsWrapper;
import com.ford.oa.commons.ui.widgets.FordToolbarLayout;
import com.ford.oa.config.Configuration;
import com.ford.oa.config.ConfigurationProvider;
import com.ford.oa.managers.AppletManager;
import com.ford.oa.managers.CrittercismManager;
import com.ford.oa.managers.ObjectGraphManager;
import com.ford.oa.models.DashboardApplet;
import com.ford.oa.vehicles.providers.VehicleInfoProvider;
import com.ford.rxutils.SafeSubscriptionManager;
import com.ford.utils.providers.LocaleProvider;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;

public abstract class BaseActivity
        extends ActionBarActivity
        implements SafeSubscriptionManager.ConvenienceMethods,
                   PermissionsRequester {
                   	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.IS_WATER_MARK_ENABLED) {
            showBuildWatermark();
        }
    }

    
    private void showBuildWatermark() {
        View decorView = getWindow().getDecorView();
        LayoutInflater inflater = getLayoutInflater();
        inflater.inflate(R.layout.view_version_watermark, (ViewGroup) decorView);
        TextView text = (TextView) decorView.findViewById(R.id.version_code_textview);
        text.setText("Build Version: " + BuildConfig.WATERMARK_VERSION_NAME + " Flavor: " + BuildConfig.FLAVOR);
    }
}
