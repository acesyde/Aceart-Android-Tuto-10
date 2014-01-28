package com.FormationNotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MonActivite extends Activity {

	private NotificationManager notificationManager;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        
        
        final Button boutonNoficiation = (Button) findViewById(R.id.boutonNotification);
        
        boutonNoficiation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Notification notification = new Notification(R.drawable.icon, 
						"Mon appli", 
						System.currentTimeMillis());
				
				notification.flags |= Notification.FLAG_AUTO_CANCEL;
				notification.defaults |= Notification.DEFAULT_VIBRATE;
				notification.vibrate = new long[] {200,300,400,500};
				
				Intent intentNotification = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:0102030405"));
				PendingIntent pendingIntent = PendingIntent.getActivity(MonActivite.this, 0, intentNotification, 0);
				notification.setLatestEventInfo(MonActivite.this, "Ma notification", "Passer un appel", pendingIntent);
				notificationManager.notify(1, notification);
			}
		});
    }
}