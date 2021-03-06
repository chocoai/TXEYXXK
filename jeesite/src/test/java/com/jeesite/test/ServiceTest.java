package com.jeesite.test;


import com.jeesite.modules.data.MultipleDataSource;
import com.jeesite.modules.test.entity.TestArea;
import com.jeesite.modules.test.service.TestAreaService;
import com.jeesite.modules.txey.entity.Bcjl;
import com.jeesite.modules.txey.entity.Heart;
import com.jeesite.modules.txey.entity.Patient;
import com.jeesite.modules.txey.service.BcjlService;
import com.jeesite.modules.txey.service.HeartService;
import com.jeesite.modules.txey.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-context.xml"})
public class ServiceTest {


    @Autowired
    private TestAreaService testAreaService;
    @Autowired
    private HeartService heartService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private BcjlService bcjlService;


    @Test
    public void getTestArea() {

        MultipleDataSource.setDataSourceKey("testDataSource");

        List<TestArea> testList = testAreaService.getArea();
        for (TestArea tl : testList) {
            System.out.println(tl);
        }

        MultipleDataSource.setDataSourceKey("dataSource");
        //System.out.println(MultipleDataSource.getDataSourceKey());
    }


    @Test
    public void getTestPatient() {

        MultipleDataSource.setDataSourceKey("hisDataSource");
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("beginDate","2017-09-13");
//		map.put("endDate","2017-09-13");
        List<Patient> patientList = patientService.getPatient();
        for (Patient p : patientList) {
            System.out.println(p);
        }

    }


    @Test
    public void getTestHeart() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("beginDate", "2017-09-15");
        paramMap.put("endDate", "2017-09-15");
        MultipleDataSource.setDataSourceKey("hisDataSource");
        List<Heart> heartList = heartService.heartStats(paramMap);
        for (Heart heart : heartList) {
            System.out.println(heart);
        }
    }


//    @Test
//    public void getTestBcjl() {
//        MultipleDataSource.setDataSourceKey("emrDataSource");
//        List<Bcjl> bcjlList = bcjlService.getBcjl("00264320");
//        for (Bcjl bcjl : bcjlList) {
//            System.out.println(bcjl);
//        }
//    }

}
