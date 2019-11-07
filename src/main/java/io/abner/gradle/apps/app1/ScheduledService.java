
package io.abner.gradle.apps.app1;

import java.util.Calendar;

import javax.persistence.LockModeType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduledService {
    Logger LOG = LoggerFactory.getLogger(ScheduledService.class);

    // @Autowired
    // ScheduledRun runService;
    @Autowired
    EmployeeService service;

    @Scheduled(fixedDelay = 25000L )
    // @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    @Transactional()
    // @Lock(LockModeType.PESSIMISTIC_WRITE)
    public void doStuff() throws InterruptedException {
        // runService.doStuff();
        //DebugUtils.transactionRequired("ScheduledService.doStuff");
        service.findAll();
        Thread.sleep(10000);
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
