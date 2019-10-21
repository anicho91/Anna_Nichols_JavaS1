package com.company.AnnaNicholsU1Capstone.dao;

import com.company.AnnaNicholsU1Capstone.dto.ProcessingFee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoTest {
    
    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {
        List<ProcessingFee> processingFees = processingFeeDao.getAllProcessingFees();
        processingFees.stream().forEach(ProcessingFee -> processingFeeDao.deleteProcessingFee(ProcessingFee.getProductType()));
    }
    
    @Test
    public void addGetDeleteProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(new BigDecimal("1.99"));
        processingFee.setProductType("TShirt");
        
        processingFeeDao.addProcessingFee(processingFee);

        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());

        assertEquals(processingFee1, processingFee);

        processingFeeDao.deleteProcessingFee(processingFee.getProductType());

        processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());

        assertNull(processingFee1);        
    }

    @Test
    public void getAllProcessingFees() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(new BigDecimal("1.99"));
        processingFee.setProductType("TShirt");
        processingFee = processingFeeDao.addProcessingFee(processingFee);

        processingFee = new ProcessingFee();
        processingFee.setFee(new BigDecimal("15.99"));
        processingFee.setProductType("ProcessingFee");
        processingFee = processingFeeDao.addProcessingFee(processingFee);

        List<ProcessingFee> processingFees = processingFeeDao.getAllProcessingFees();
        assertEquals(processingFees.size(), 2);
    }

    @Test
    public void updateProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(new BigDecimal("1.99"));
        processingFee.setProductType("TShirt");
        processingFee = processingFeeDao.addProcessingFee(processingFee);

        processingFee.setFee(new BigDecimal("2.50"));
        processingFeeDao.updateProcessingFee(processingFee);

        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());

        assertEquals(processingFee1, processingFee);

    }
}