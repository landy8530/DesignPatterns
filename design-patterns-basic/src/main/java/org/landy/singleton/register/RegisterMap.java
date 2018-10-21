package org.landy.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Landy on 2018/8/21.
 */
public class RegisterMap {
    private RegisterMap(){}

    private static Map<String,Object> register = new ConcurrentHashMap<>();

    public static RegisterMap getInstance(String name){
        if(name == null){
            name = RegisterMap.class.getName();
        }

        if(register.get(name) == null){
            try {
                //register.put(name,Class.forName(name).newInstance());
                register.put(name, new RegisterMap());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return (RegisterMap)register.get(name);
    }


}
