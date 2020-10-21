/**
 * Created by Zhouyi.Fan on 2020/10/17.
 *
 * @version 版本号:1.01
 */

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * DESCRIPTION:
 **/
public class MyClassLoader extends ClassLoader {



    public static void main(String[] args) {
        try {
            Class<?> aClass = new MyClassLoader().findClass("Hello");
            Object o = aClass.newInstance();
            Method method = null;
            /**call method */
            method = aClass.getMethod("hello");
            method.invoke(o);
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected Class<?> findClass(String name) {

        /**read bytes */
        byte[] bytes = new byte[0];
        try {

            String pathname = this.getClass().getClassLoader().getResource("Hello.xlass").getPath();

            bytes = readFromByteFile(pathname);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        /** find class*/
        return defineClass(name, bytes, 0, bytes.length);

    }

    public byte[] readFromByteFile(String pathname) throws IOException {

        File file = new File(pathname);

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] temp = new byte[1024];
        int size = 0;
        while ((size = in.read(temp)) != -1) {
            for (int i = 0; i < size; i++) {
                int x = temp[i] & 0xff;
                temp[i] = (byte) (255 - x);
            }
            out.write(temp, 0, size);
        }
        in.close();
        byte[] content = out.toByteArray();

        return content;

    }

}
