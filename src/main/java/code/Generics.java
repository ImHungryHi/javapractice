package code;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;

public class Generics {
    public static <E> HashMap<String, String> getObjectFields(Class<E> genClass) {
        HashMap<String, String> results = new HashMap<>();
        Field[] fields = genClass.getDeclaredFields();

        for (Field field : fields) {
            results.put(field.getName(), field.getType().getSimpleName());
        }

        return results;
    }

    public static <E> void setValue(Class<E> objInstance, Field field, byte[] value) throws IllegalAccessException{
        switch(field.getType().getSimpleName()) {
            case "int":
                field.setInt(objInstance, ByteBuffer.wrap(value).getInt());
                break;
            case "double":
                field.setDouble(objInstance, ByteBuffer.wrap(value).getDouble());
                break;
            case "short":
                field.setShort(objInstance, ByteBuffer.wrap(value).getShort());
                break;
            case "long":
                field.setLong(objInstance, ByteBuffer.wrap(value).getLong());
                break;
            case "boolean":
                field.setBoolean(objInstance, (ByteBuffer.wrap(value).getInt() == 1));
                break;
            case "float":
                field.setFloat(objInstance, ByteBuffer.wrap(value).getFloat());
                break;
            case "char":
                field.setChar(objInstance, ByteBuffer.wrap(value).getChar());
                break;
            case "byte":
                field.setByte(objInstance, ByteBuffer.wrap(value).get());
                break;
            case "String":
                field.set(objInstance, new String(value));
                break;
            default:
                // Let's not transform byte arrays to random objects such as Person, Car, etc...
                break;
        }
    }

    public static float upperBoundedWildcardTotal(List<? extends Number> numbers) {
        float total = 0;

        for (Number number : numbers) {
            total += number.floatValue();
        }

        return total;
    }

    public static void lowerBoundedWildcard(List<? super String> list) {
        list.add("Yo");
    }
}
