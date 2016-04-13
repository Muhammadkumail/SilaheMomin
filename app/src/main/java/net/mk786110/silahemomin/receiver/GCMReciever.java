package net.mk786110.silahemomin.receiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import net.mk786110.silahemomin.service.GCMService;

public class GCMReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setClass(context, GCMService.class);
        context.startService(intent);

    }
}
