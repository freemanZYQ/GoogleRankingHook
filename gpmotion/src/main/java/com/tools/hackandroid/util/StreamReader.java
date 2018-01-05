package com.tools.hackandroid.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2015/1/16.
 */
public class StreamReader extends Thread
{

	private InputStream is;
	private StringBuilder mBuffer;
	private String mCharset;
	private CountDownLatch mCountDownLatch;

	public StreamReader(InputStream is, String charset)
	{
		this.is = is;
		mCharset = charset;
		mBuffer = new StringBuilder();
		mCountDownLatch = new CountDownLatch(1);
	}

	public String getResult()
	{
		try
		{
			mCountDownLatch.await();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return mBuffer.toString();
	}

	@Override
	public void run()
	{
		InputStreamReader isr = null;
		try
		{
			isr = new InputStreamReader(is, mCharset);
			int c = -1;
			while ((c = isr.read()) != -1)
			{
				mBuffer.append((char) c);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (isr != null)
			{
				try
				{
					isr.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			mCountDownLatch.countDown();
		}
	}
}
