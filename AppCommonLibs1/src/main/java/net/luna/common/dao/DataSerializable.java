package net.luna.common.dao;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * @author bintou
 * @version 创建时间：2015年6月26日 下午3:19:42
 */
public interface DataSerializable extends Serializable {

	public String deSerialize();

	public boolean serialize(JSONObject json);

}
