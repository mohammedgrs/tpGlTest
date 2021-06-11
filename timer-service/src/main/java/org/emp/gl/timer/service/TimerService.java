package org.emp.gl.timer.service;

public interface TimerService {
    static String SECOND="SECOND";
    void addListener(TimerChangeListener l);
    void removeListener(TimerChangeListener l);
}
