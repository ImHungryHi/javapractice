package code;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;

public class Generics {
    public static boolean validateFieldsForValue(Object haystack, List<String> fieldNames, String needle) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        boolean resultFound = false;

        for (Field field : haystack.getClass().getDeclaredFields()) {
            for (String fieldName : fieldNames) {
                if (field.getType().isAssignableFrom(String.class) && field.getName().contains(fieldName)) {
                    Method method = haystack.getClass().getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
                    Object[] args = new Object[0];
                    String value = (String) method.invoke(haystack, args);

                    if (value != null && value.equals(needle)) {
                        resultFound = true;
                    }
                }
            }
        }

        return resultFound;
    }
    
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
