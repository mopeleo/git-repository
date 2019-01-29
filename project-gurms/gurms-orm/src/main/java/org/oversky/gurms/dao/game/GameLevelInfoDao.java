package org.oversky.gurms.dao.game;

import org.oversky.gurms.entity.game.GameLevelInfo;
import java.util.List;

public interface GameLevelInfoDao{

    int insert(GameLevelInfo entity);

    List<GameLevelInfo> selectAll(GameLevelInfo where);

    GameLevelInfo selectById(Integer levelid);

    int deleteById(Integer levelid);

    int updateById(GameLevelInfo entity);
	
    int dynamicUpdateById(GameLevelInfo entity);
}
