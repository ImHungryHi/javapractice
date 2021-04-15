package code;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class Generics {
    public static <E> HashMap<String, String> getObjectFields(Class<E> genClass) {
        HashMap<String, String> results = new HashMap<>();
        Field[] fields = genClass.getDeclaredFields();

        for (Field field : fields) {
            results.put(field.getName(), field.getType().getSimpleName());
        }

        return results;
    }

    public static <E> void setValue(Class<E> obj, Field field, byte[] value) throws IllegalAccessException{
        switch(field.getType().getSimpleName()) {
            case "int":
                field.setInt(obj, ByteBuffer.wrap(value).getInt());
                break;
            case "double":
                field.setDouble(obj, ByteBuffer.wrap(value).getDouble());
                break;
            case "short":
                field.setShort(obj, ByteBuffer.wrap(value).getShort());
                break;
            case "long":
                field.setLong(obj, ByteBuffer.wrap(value).getLong());
                break;
            case "boolean":
                field.setBoolean(obj, (ByteBuffer.wrap(value).getInt() == 1));
                break;
            case "float":
                field.setFloat(obj, ByteBuffer.wrap(value).getFloat());
                break;
            case "char":
                field.setChar(obj, ByteBuffer.wrap(value).getChar());
                break;
            case "byte":
                field.setByte(obj, ByteBuffer.wrap(value).get());
                break;
            case "String":
                field.set(obj, new String(value));
                break;
            default:
                // Let's not transform byte arrays to random objects such as Person, Car, etc...
                break;
        }
    }
}
