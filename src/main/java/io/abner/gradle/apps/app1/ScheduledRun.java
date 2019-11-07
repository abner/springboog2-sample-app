package io.abner.gradle.apps.app1;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScheduledRun {

    Logger LOG = LoggerFactory.getLogger(ScheduledRun.class);

    @Autowired
    EmployeeService service;

    @Transactional(propagation = Propagation.MANDATORY)
    public void doStuff() throws InterruptedException {

        DebugUtils.transactionRequired("ScheduledRun.doStuff");
        Employee j = new Employee();
        j.setEmployeeId(Calendar.getInstance().getTime().hashCode() + "");
        j.setEmployeeAddress("employeeAddress");
        j.setEmployeeEmail("employeeEmail");
        j.setEmployeeName("employeeName");
        service.insertEmployee(j);
        service.findAll();
        Thread.sleep(10000);
        LOG.info("Executou tarefa agendada as " + Calendar.getInstance().getTime().toString());
    }

}