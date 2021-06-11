/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer.service;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface TimerChangeListener extends PropertyChangeListener {
    static String SECOND="SECOND";

    @Override
    void propertyChange(PropertyChangeEvent evt);
}

