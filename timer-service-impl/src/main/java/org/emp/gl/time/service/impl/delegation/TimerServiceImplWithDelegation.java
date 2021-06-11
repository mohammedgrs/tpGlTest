package org.emp.gl.time.service.impl.delegation;

import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerServiceImplWithDelegation extends TimerTask implements TimerService {
    PropertyChangeSupport pcs=new PropertyChangeSupport(this);
    public TimerServiceImplWithDelegation(){
        Timer timer = new Timer();
        LocalTime localTime = LocalTime.now();
        timer.scheduleAtFixedRate(this, 100, 1000);
    }

    @Override
    public void run() {
        System.out.println("run");
        PropertyChangeEvent pce=new PropertyChangeEvent(this,SECOND,null,null);
        pcs.firePropertyChange(pce);
    }

    @Override
    public void addListener(TimerChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    @Override
    public void removeListener(TimerChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }
}
