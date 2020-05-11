package net.kuper.tz.common.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.common.dao.AreaDao;
import net.kuper.tz.common.entity.AreaEntity;
import net.kuper.tz.common.entity.AreaQueryEntity;
import net.kuper.tz.common.entity.AreaUpdateEntity;
import net.kuper.tz.common.service.AreaService;
import net.kuper.tz.core.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 区域Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public Pagination<AreaEntity> queryList(AreaQueryEntity areaQueryEntity) {
        PageHelper.startPage(areaQueryEntity.getPage(), areaQueryEntity.getPageSize());
        List<AreaEntity> areaList = areaDao.queryList(areaQueryEntity);
        return new Pagination<AreaEntity>(areaList);
    }

    @Override
    public List<AreaEntity> queryList(Integer parentId,Integer status) {
        AreaQueryEntity areaQueryEntity = new AreaQueryEntity();
        areaQueryEntity.setParentId(parentId);
        areaQueryEntity.setStatus(status);
        List<AreaEntity> areaList = areaDao.queryList(areaQueryEntity);
        return areaList;
    }

    @Override
    public AreaEntity queryObject(Integer id) {
        AreaEntity entity = areaDao.queryObject(id);
        entity.setPath(areaDao.getPath(id));
        return entity;
    }

    @Override
    public AreaEntity save(AreaUpdateEntity areaUpdateEntity) {
        areaDao.save(areaUpdateEntity);
        return areaDao.queryObject(areaUpdateEntity.getId());
    }

    @Override
    public void update(AreaUpdateEntity areaUpdateEntity) {
        areaDao.update(areaUpdateEntity);
    }

    @Override
    public void delete(Integer id) {
        areaDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        areaDao.deleteBatch(ids);
    }
}
