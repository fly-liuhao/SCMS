/**
* @项目名称: SCMS
* @文件名称: MajorServiceImpl.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.dao.MajorDao;
import cn.edu.tyust.scms.model.Major;

/**
 * 专业Service接口实现类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class MajorServiceImpl implements MajorService {
    private MajorDao majorDao = new MajorDao();

    @Override
    public List<Major> findMajors(Map<String, Object> map) {
        return majorDao.selectMajors(map);
    }

}
