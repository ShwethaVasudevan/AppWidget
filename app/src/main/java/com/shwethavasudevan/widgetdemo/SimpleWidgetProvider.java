package com.shwethavasudevan.widgetdemo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by shwethavasudevan on 17/03/18.
 */

public class SimpleWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int count = appWidgetIds.length;

        for(int i=0;i<count;i++) {
            int widgetId = appWidgetIds[i];


            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.simple_widget);


            // first button
            Intent intent = new Intent(context, SimpleWidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.actionButton,pendingIntent);

            // intent for second button

            //Intent intent2 = new Intent(context, <enter package name> );
            //intent2.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            //intent2.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,appWidgetIds);

            //PendingIntent pendingIntent2 = PendingIntent.getBroadcast(context,1, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
            //remoteViews.setOnClickPendingIntent(R.id.btn2, pendingIntent2);
            appWidgetManager.updateAppWidget(widgetId,remoteViews);



        }


    }
}
