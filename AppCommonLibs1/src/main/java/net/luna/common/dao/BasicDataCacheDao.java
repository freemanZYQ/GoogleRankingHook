package net.luna.common.dao;

import java.io.Serializable;

/**
 * @author bintou
 */
public interface BasicDataCacheDao {

	/**
	 * 
	 * @param value
	 * @return 返回行号ID,如果返回-1 ，则插入失败
	 */
	public long insertData(String value);

	public long insertData(int value);

	public long insertData(long value);

	public long insertData(boolean value);

	public long insertData(DataSerializable value);

	public long insertData(byte[] value);

	public String getString(String key);

	public int getInt(String key);

	public boolean getBoolean(String key);

	public long getLong(String key);

	public Serializable getSerializable(String key);

	public byte[] getBytes(String key);

	public int deleteData(String key);

	public int deleteAllData();

}
