package J_N_Super_Pvt_Ltd.asset.message.service;


import J_N_Super_Pvt_Ltd.asset.message.dao.EmailMessageDao;
import J_N_Super_Pvt_Ltd.asset.message.entity.EmailMessage;
import J_N_Super_Pvt_Ltd.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@CacheConfig(cacheNames = "emailMessage")
public class EmailMessageService implements AbstractService<EmailMessage, Integer> {
    private final EmailMessageDao emailMessageDao;

    @Autowired
    public EmailMessageService(EmailMessageDao emailMessageDao) {
        this.emailMessageDao = emailMessageDao;
    }

    @Override
    @Cacheable
    public List<EmailMessage> findAll() {
        return emailMessageDao.findAll();
    }

    @Override
    @Cacheable
    public EmailMessage findById(Integer id) {
        return emailMessageDao.getOne(id);
    }

    @Override
    @Caching(evict = {@CacheEvict(value = "emailMessage", allEntries = true)},
            put = {@CachePut(value = "emailMessage", key = "#emailMessage.id")})
    public EmailMessage persist(EmailMessage emailMessage) {
        return emailMessageDao.save(emailMessage);
    }

    @Override
    @CacheEvict(allEntries = true)
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<EmailMessage> search(EmailMessage emailMessage) {
        return null;
    }
}
