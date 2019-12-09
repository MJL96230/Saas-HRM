package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 保存企业
     * @param company
     */
    public void add(Company company){
        long id = idWorker.nextId();
        company.setId(String.valueOf(id));
        company.setAuditState("0");
        company.setState(1);
        companyDao.save(company);
    }

    /**
     * 更新企业
     * @param company
     */
    public void update(Company company){
        Company temp = companyDao.findById(company.getId()).get();
        temp.setName(company.getName());
        temp.setCompanyPhone(company.getCompanyPhone());
        companyDao.save(temp);
    }

    /**
     *根据id删除企业
     * @param id
     */
    public void deleteById(String id){
        companyDao.deleteById(id);
    }

    /**
     * 根据id查询企业
     * @param id
     * @return
     */
    public Company findById(String id){
        return companyDao.findById(id).get();
    }

    public List<Company> findAll(){
        return companyDao.findAll();
    }
}
