package fi.joniaromaa.minecrafthook.fabric1_16.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class UnsafeUtils
{
    private static Object unsafeInstance;
    private static Method unsafeAllocateInstance;

    static
    {
        try
        {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");

            Field unsafeField = unsafeClass.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);

            UnsafeUtils.unsafeInstance = unsafeField.get(null);
            UnsafeUtils.unsafeAllocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T allocateInstance(Class<T> clazz)
    {
        try
        {
            return (T)UnsafeUtils.unsafeAllocateInstance.invoke(UnsafeUtils.unsafeInstance, clazz);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
    }
}