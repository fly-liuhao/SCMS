/**
* @项目名称: SCMS
* @文件名称: MajorMapper.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.mapper;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.model.Major;

/**
 * 专业映射接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface MajorMapper {

    /**
     * 查询专业
     * 
     * @param map 查询条件集合
     * @return 查询出的专业集合
     */
    public List<Major> selectMajors(Map<String, Object> map);

}
