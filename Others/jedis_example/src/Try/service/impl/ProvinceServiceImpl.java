package Try.service.impl;

import Try.dao.ProvinceDao;
import Try.dao.impl.ProvinceDaoImpl;
import Try.domain.Province;
import Try.service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        /*
        使用redis缓存
         */
        return null;
    }
}
