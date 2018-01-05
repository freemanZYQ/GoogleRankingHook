package net.luna.common.util;

/**
 * Created by bintou on 2016/11/1.
 */

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Gergul 函数执行超时
 * @Notice: 不能执行同名而且参数数量相同的函数！！
 * @Usage: RunningTimeout.Run(类对象, 方法名字, 参数列表, 超时时间 单位毫秒);
 */
public class RunningTimeout implements Callable<Object> {
    private Object ower = null;
    private String sMethodName = null;
    // private Class[] paramTypes;
    private Object[] paramValues;

    // 外部接口
    public static Object Run(Object ower, String sMethodName,
                             Object[] paramValues, long timeout) throws InterruptedException,
            ExecutionException, TimeoutException {
        RunningTimeout rt = new RunningTimeout();
        return rt._run(ower, sMethodName, paramValues, timeout);
    }

    // 不允许new
    private RunningTimeout() {
    }

    //
    private Object _run(Object ower, String sMethodName, Object[] paramValues,
                        long timeout) throws InterruptedException, ExecutionException,
            TimeoutException {
        this.ower = ower;
        this.sMethodName = sMethodName;
        this.paramValues = paramValues;

        // 关键代码
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<Object> future = (FutureTask<Object>) executor.submit(this);
        executor.execute(future);

        return future.get(timeout, TimeUnit.MILLISECONDS);
    }

    // 真正做事的地方
    @Override
    public Object call() throws Exception {
        // TODO Auto-generated method stub
        Method[] methods = ower.getClass().getDeclaredMethods();
        int n = methods.length;
        for (int i = 0; i < n; i++) {
            if (sMethodName.equals(methods[i].getName())) {
                Method thisMethod = methods[i];
                if (thisMethod.getParameterTypes().length == (paramValues != null ? paramValues.length : 0)) {// 检查参数的数量是否相同
                    return methods[i].invoke(ower, paramValues);
                }
            }
        }

        throw new Exception("No this method.");
    }

}