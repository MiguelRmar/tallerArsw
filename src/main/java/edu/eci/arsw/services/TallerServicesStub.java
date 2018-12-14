/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.services;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import edu.eci.arsw.persistence.TallerPersistence;

/**
 *
 * @author Miguel
 */
@Service
public class TallerServicesStub implements TallerServices{

    @Autowired
    @Qualifier("Alpha")
    TallerPersistence pPersistence;
    
    @Override
    public String getIntradayShare(String shareName) throws IOException{
        return pPersistence.getIntradayShare(shareName);
    }

    @Override
    public String getDiaryShare(String shareName) throws IOException{
        return pPersistence.getDiaryShare(shareName);
    }

    @Override
    public String getWeeklyShare(String shareName) throws IOException{
        return pPersistence.getWeeklyShare(shareName);
    }

    @Override
    public String getMonthlyShare(String shareName) throws IOException{
        return pPersistence.getMonthlyShare(shareName);
    }
    
}
