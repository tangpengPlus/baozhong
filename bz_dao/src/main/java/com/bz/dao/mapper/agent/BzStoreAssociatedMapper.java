package com.bz.dao.mapper.agent;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.agent.BzStoreAssociated;

public interface BzStoreAssociatedMapper extends BaseMapper<BzStoreAssociated> {
    /**
     *  动态字段,写入数据库记录,bz_store_associated
     *
     * @param record
     */
    int insertSelective(BzStoreAssociated record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,bz_store_associated
     *
     * @param record
     */
    int updateByPrimaryKeySelective(BzStoreAssociated record);
    
    /**
     * 
     * 作者: 兰俊
     * 描述: 根据合伙人id获取店铺id集合
     * 创建时间:2017年11月22日下午2:49:53
     * @param id 合伙人id
     * @return 店铺集合
     */
    List<Integer> getShopIdsByAgentId(Integer id); 
    
    /**
     * @author 陈青山
     * @miaoshu 查询合伙人关联的店铺id集合
     * @param userid
     * @param max
     * @param min
     * @return
     */
    List<String> selectShop(@Param(value = "userid") String userid ,@Param(value="max")int max,@Param(value="min")int min);
}