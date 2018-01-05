package net.luna.common.dao.impl;

import android.content.ContentValues;
import android.database.Cursor;

import net.luna.common.dao.BasicDataCacheDao;
import net.luna.common.dao.DataSerializable;
import net.luna.common.util.SqliteUtils;
import net.luna.common.util.StringUtils;

import java.io.Serializable;

/**
 * @author bintou
 * @version 创建时间：2015年6月26日 上午11:47:16
 */
public class BasicDataCacheImpl implements BasicDataCacheDao {

	private SqliteUtils sqliteUtils;

	private String tableName;
	private String rowName;
	private int rowIndex;

	public BasicDataCacheImpl(SqliteUtils sqliteUtils) {
		this.sqliteUtils = sqliteUtils;
	}

	@Override
	public long insertData(String value) {
		if (StringUtils.isBlank(value)) {
			return -1;
		}
		ContentValues contentValues = new ContentValues();
		contentValues.put(rowName, value);
		synchronized (BasicDataCacheImpl.class) {
			return sqliteUtils.getDb().replace(tableName, null, contentValues);
		}
	}

	@Override
	public long insertData(int value) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(rowName, value);
		synchronized (BasicDataCacheImpl.class) {
			return sqliteUtils.getDb().replace(tableName, null, contentValues);
		}
	}

	@Override
	public long insertData(long value) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(rowName, value);
		synchronized (BasicDataCacheImpl.class) {
			return sqliteUtils.getDb().replace(tableName, null, contentValues);
		}
	}

	@Override
	public long insertData(boolean value) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(rowName, value);
		synchronized (BasicDataCacheImpl.class) {
			return sqliteUtils.getDb().replace(tableName, null, contentValues);
		}
	}

	@Override
	public long insertData(DataSerializable value) {
		String valueStr = value.deSerialize();
		if (StringUtils.isBlank(valueStr)) {
			return -1;
		}
		ContentValues contentValues = new ContentValues();
		contentValues.put(rowName, valueStr);
		synchronized (BasicDataCacheImpl.class) {
			return sqliteUtils.getDb().replace(tableName, null, contentValues);
		}
	}

	@Override
	public String getString(String key) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}
		StringBuilder appWhere = new StringBuilder();
		appWhere.append(rowName).append("=?");
		String[] appWhereArgs = { key };
		synchronized (BasicDataCacheImpl.class) {
			Cursor cursor = sqliteUtils.getDb().query(tableName, null, appWhere.toString(), appWhereArgs, null, null,
					null);
			if (cursor == null) {
				return null;
			}
			String value = null;
			if (cursor.moveToFirst()) {
				value = cursor.getString(rowIndex);
			}
			if (!cursor.isClosed()) {
				cursor.close();
			}
			return value;
		}

	}

	@Override
	public int getInt(String key) {
		return 0;
	}

	@Override
	public boolean getBoolean(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getLong(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Serializable getSerializable(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteData(String key) {
		return 0;
	}

	@Override
	public int deleteAllData() {
		return sqliteUtils.getDb().delete(tableName, null, null);
	}

	@Override
	public long insertData(byte[] value) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(rowName, value);
		synchronized (BasicDataCacheImpl.class) {
			return sqliteUtils.getDb().replace(tableName, null, contentValues);
		}
	}

	@Override
	public byte[] getBytes(String key) {
		return null;
	}

}
