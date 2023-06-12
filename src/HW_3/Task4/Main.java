package HW_3.Task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface A {}

interface B {}

interface C {}

interface D
        extends A, B {}

interface E
        extends C, D {}

class Cl1
        implements A {}

class Cl2
        extends Cl1
        implements E {}

/*
Написать метод, который с помощью рефлексии получит все интерфейсы класса,
включая интерфейсы от классов-родителей и интерфейсов-родителей.
 */
public class Main {
    public static void main(String[] args) {
        List<Class<?>> interfaces = getAllInterfaces(Cl2.class);
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        else {
            List<Class<?>> interfaces = new ArrayList<>();
            getAllInterfacesOfParents(cls, interfaces);
            return interfaces;
        }
    }

    private static void getAllInterfacesOfParents(Class<?> cls,
                                                  List<Class<?>> interfacesFound) {
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                if (!interfacesFound.contains(anInterface)) {
                    interfacesFound.add(anInterface);
                    getAllInterfacesOfParents(anInterface, interfacesFound);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    //Решение Руслана
    public static List<Class<?>> getAllInterfaces1(Class<?> cls) {
        List<Class<?>> interfaces = new ArrayList<>();

        while (cls != Object.class) {
            interfaces.addAll(Arrays.asList(cls.getInterfaces()));
            cls = cls.getSuperclass();
        }

        for (int i = 0; i < interfaces.size(); i++) {
            interfaces.addAll(i + 1, Arrays.asList(interfaces.get(i).getInterfaces()));
        }

        return interfaces;
    }

    //альтернатива рекурсии
    public static List<Class<?>> getAllInterfaces2(Class<?> cls) {
        List<Class<?>> interfaces = new ArrayList<>();
        while (cls != Object.class) {
            for (Class<?> anInterface : cls.getInterfaces()) {
                interfaces.add(anInterface);
                Class<?>[] arrayInterface = anInterface.getInterfaces();
                while (arrayInterface.length > 0) {
                    for (Class<?> elementInterface : arrayInterface) {
                        anInterface = elementInterface;
                        interfaces.add(anInterface);
                        arrayInterface = anInterface.getInterfaces();
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return interfaces;
    }


}