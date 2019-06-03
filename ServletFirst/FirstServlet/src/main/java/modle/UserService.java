package modle;

import service.QueryService;
import tool.DbManager;
import vo.userInfo;

import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/6/3 0003
 */

//模型层
public class UserService {

    private QueryService queryService = new QueryService();

    public List<userInfo> queryUserFun() {

        return queryService.queryFunction();
    }
}
