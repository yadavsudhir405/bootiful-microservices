package com.example;

import java.io.*;

/**
 * @author sudhir
 *         Date:22/11/16
 *         Time:12:41 PM
 *         Project:config-server
 */
public class SerializationRuner {
    public static void main(String[] args) {
        Person p=new Person();
        p.setName("Sudhir");
        //p.setAge(27);
        //serialize(p);
        //System.out.println("Object serialized");
        Person person=deserializePerson();
        System.out.println(person);
    }
    private static void serialize(Person person){
        ObjectOutputStream objectOutputStream=null;
        try{
             objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File("person.ser")));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        try {
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    private static Person deserializePerson() {
        ObjectInputStream objectInputStream = null;
        Person person=null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(new File("person.ser")));
             person = (Person) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }
}
